package com.endura.pos_system.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.endura.pos_system.R;
import com.endura.pos_system.base.BaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button submit;

//    private String stringUsername = "test";
//    private String stringPassword = "1234";
    private String inputUsername = "";
    private String inputPassword = "";
    private JSONArray resultArray = null;

    private boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.login_button);

        submit.setOnClickListener(v -> {

            inputUsername = username.getText().toString();
            inputPassword = password.getText().toString();

//                data_MySQL1 dataMySQL = new data_MySQL1();
//                data_MySQL sql = new data_MySQL();
//                sql.execute(inputUsername, inputPassword);

            if (inputUsername.isEmpty() || inputPassword.isEmpty())
            {
                Toast.makeText(LoginActivity.this, "Please enter all the details!", Toast.LENGTH_SHORT).show();
            } else {
                Thread thread = new Thread(mutiThread);
                thread.start();
            }
        });
    }

    private boolean validate(String username, String password) {
        try {
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject jsonObject = resultArray.getJSONObject(i);
                String username_database = jsonObject.getString("username");
                String password_database = jsonObject.getString("password");
//                Log.d("TAG", "title:" + username + ", tag:" + password);
                if (username.equals(username_database) && password.equals(password_database)){
                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(i == resultArray.length()) {
                    Toast.makeText(LoginActivity.this, "Wrong username or password!", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else
                    continue;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, BaseActivity.class);
        startActivity(intent);
    }

        private Runnable mutiThread = new Runnable(){
            public void run()
            {
                try {
                    URL url = new URL("http://10.0.2.2/testGetData.php");
                    // 開始宣告 HTTP 連線需要的物件，這邊通常都是一綑的
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    // 建立 Google 比較挺的 HttpURLConnection 物件
                    connection.setRequestMethod("POST");
                    // 設定連線方式為 POST
                    connection.setDoOutput(true); // 允許輸出
                    connection.setDoInput(true); // 允許讀入
                    connection.setUseCaches(false); // 不使用快取
                    connection.connect(); // 開始連線

                    int responseCode =
                            connection.getResponseCode();
                    // 建立取得回應的物件
                    if(responseCode ==
                            HttpURLConnection.HTTP_OK){
                        // 如果 HTTP 回傳狀態是 OK ，而不是 Error
                        InputStream inputStream =
                                connection.getInputStream();
                        // 取得輸入串流
                        BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
                        // 讀取輸入串流的資料
                        String box = ""; // 宣告存放用字串
                        String line = null; // 宣告讀取用的字串
                        while((line = bufReader.readLine()) != null) {
                            box += line + "\n";
                            // 每當讀取出一列，就加到存放字串後面
                        }
                        inputStream.close(); // 關閉輸入串流
                        String result = box; // 把存放用字串放到全域變數
                        resultArray = new JSONArray(result);
                    }

                    // 讀取輸入串流並存到字串的部分
                    // 取得資料後想用不同的格式
                    // 例如 Json 等等，都是在這一段做處理

                } catch(Exception e) {
                    e.toString(); // 如果出事，回傳錯誤訊息
                }

                // 當這個執行緒完全跑完後執行
                runOnUiThread(new Runnable() {
                    public void run() {
                        isValid = validate(inputUsername, inputPassword);
                        if (!isValid)
                        {
                            Toast.makeText(LoginActivity.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            // 開始執行
                            openMainActivity();

                        }
                    }
                });
            }
        };

}
