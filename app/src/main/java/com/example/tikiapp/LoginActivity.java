package com.example.tikiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextView textRegister;
    MaterialButton loginButton;
    TextInputLayout inputLayoutPhoneNumber, inputLayoutPassword;
    TextInputEditText  inputPhoneNumber , inputPassword;
    String textPhoneNumber, textPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textRegister = findViewById(R.id.textRegister);
        loginButton = findViewById(R.id.login_button);
        inputPhoneNumber = findViewById(R.id.login_input_phoneNumber);
        inputPassword = findViewById(R.id.login_input_password);
        inputLayoutPhoneNumber=findViewById(R.id.login_inputLayout_phoneNumber);
        inputLayoutPassword=findViewById(R.id.login_imputLayout_password);

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textPhoneNumber = inputPhoneNumber.getText().toString().trim();
                textPassword = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(textPassword)||TextUtils.isEmpty(textPhoneNumber)){
                    if (TextUtils.isEmpty(textPassword)){
                        inputLayoutPassword.setError("Password field can't be empty!");
                    }else{
                        inputLayoutPassword.setError(null);
                    }if (TextUtils.isEmpty(textPhoneNumber)){
                        inputLayoutPhoneNumber.setError("PhoneNumber field can't be empty!");
                    }else{
                        inputLayoutPhoneNumber.setError(null);
                    }
                }else{
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                };

            }
        });

    }
}