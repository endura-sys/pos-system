package com.endura.pos_system.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;


public class Login extends Activity {
    private TextInputLayout textInputLoginID;
    private TextInputLayout textInputPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(com.endura.pos_system.R.layout.activity_login);

        textInputLoginID = findViewById(com.endura.pos_system.R.id.LoginBox);
        textInputPassword = findViewById(com.endura.pos_system.R.id.PasswordBox);
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

}
