package com.taes.paula.aidhurt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText login;
    EditText password;
    Button bLogin;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText)findViewById(R.id.usuarioText);
        password = (EditText)findViewById(R.id.passwordText);
        bLogin = (Button)findViewById(R.id.bLogin);
        bRegister =(Button)findViewById(R.id.bRegistro);

    }

    public void clickLogin(View view) {
        System.out.println(password.getText().toString());
        if(login.getText().toString().equals("Cristina") && password.getText().toString().equals("123456")){
            SaveSharedPreference.setUserName(getApplicationContext(), "Cristina");
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            System.out.println("jjjjj");
        }


    }
}
