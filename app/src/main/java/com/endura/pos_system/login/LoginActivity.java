package com.endura.pos_system.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.endura.pos_system.R;
import com.endura.pos_system.base.BaseActivity;


public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button submit;

    private String stringUsername = "test";
    private String stringPassword = "1234";

    private boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.login_button);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();
                if (inputUsername.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please enter all the details!", Toast.LENGTH_SHORT).show();
                } else {
                    isValid = validate(inputUsername, inputPassword);

                    if (!isValid)
                    {
                        Toast.makeText(LoginActivity.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        openMainActivity();
                    }
                }
            }
        });
    }


    private boolean validate(String username, String password) {
        if (username.equals(stringUsername) && password.equals(stringPassword)){
            return true;
        }
        return false;
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, BaseActivity.class);
        startActivity(intent);
    }

}
