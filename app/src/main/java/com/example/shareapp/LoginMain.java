package com.example.shareapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class LoginMain extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogin;
    private Button buttonRegister;

    private EditText inputUser;
    private EditText inputPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        inputUser = findViewById(R.id.txtUserName);
        inputPassword = findViewById(R.id.editTextPassword);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = inputUser.toString();
                String password = inputPassword.toString();

                String url = "http://10.0.2.2:8080/apiz-0.0.1-SNAPSHOT/ExecuteLogin/" + user + "/" + password;

                String salida;

                try {
                    salida = CallApi.callApi(user, password);
                    Toast toast = Toast.makeText(getApplicationContext(), salida, Toast.LENGTH_SHORT);
                    toast.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });

    }

    @Override
    public void onClick(View v) {

    }
}