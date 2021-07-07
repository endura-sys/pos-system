package com.endura.pos_system.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.endura.pos_system.MainActivity;
import com.endura.pos_system.R;
import com.google.android.material.textfield.TextInputLayout;


public class Login extends Activity {
    private TextInputLayout textInputLoginID;
    private TextInputLayout textInputPassword;
    private Button Signinbutton;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(com.endura.pos_system.R.layout.activity_login);

        EditText textInputLoginID = findViewById(com.endura.pos_system.R.id.LoginBox);
        EditText textInputPassword = findViewById(com.endura.pos_system.R.id.PasswordBox);
        Signinbutton = findViewById(R.id.Signinbutton);
    }

    private boolean ValidateLoginID() {
        String LoginIdInput = textInputLoginID.getEditText().getText().toString().trim();

        if (LoginIdInput.isEmpty()){
            textInputLoginID.setError("Field cannot be empty");
            return false;
        } else {
            textInputLoginID.setError(null);
            return true;
        }

    }

    private boolean ValidatePassword() {
        String PasswordInput = textInputPassword.getEditText().getText().toString().trim();

        if (PasswordInput.isEmpty()){
            textInputPassword.setError("Field cannot be empty");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }
    public void confirmInput(View v) {
        if (!ValidateLoginID() | !ValidatePassword()) {
            return;
        }

        String input = "LoginID: " + textInputLoginID.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

    private void loginDetails() {

        Signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String attemptLogin = textInputLoginID.getEditText().getText().toString();
                String attemptPassword = textInputPassword.getEditText().getText().toString();
                    if(attemptLogin.equals("admin") && attemptPassword.equals("Password123%")) {
                        openmain_activity();
                    }
                        else {
                            textInputLoginID.setError("Wrong LoginID/Password");
                            textInputPassword.setError("Wrong LoginID/Password");
                        }
                }
            });
        }
    public void openmain_activity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
