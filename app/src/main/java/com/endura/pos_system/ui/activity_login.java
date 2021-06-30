package com.endura.pos_system.ui;

import android.os.Bundle;

public abstract class activity_login {
    private String textInputLoginID = null;
    private String textInputPassword = null;

    textInputLoginID = abstract void findViewById(R.id.LoginBox);

    textInputPassword = abstract void findViewById(R.id.PasswordBox);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    }


