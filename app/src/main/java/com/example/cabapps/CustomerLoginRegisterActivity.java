package com.example.cabapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomerLoginRegisterActivity extends AppCompatActivity {

    TextView Title;
    TextView Register;
    TextView Login;
    Button RegisterBtn;
    Button LoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login_register);

        Register = findViewById(R.id.doRegister);
        Login = findViewById(R.id.doLogin);
        Title = findViewById(R.id.textView4);
        RegisterBtn = findViewById(R.id.CustomerRegisterBtn);
        LoginBtn = findViewById(R.id.CustomerLoginBtn);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Title.setText("Driver Register");
                LoginBtn.setVisibility(View.GONE);
                Register.setVisibility(View.GONE);
                RegisterBtn.setVisibility(View.VISIBLE);
                Login.setVisibility(View.VISIBLE);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Title.setText("Driver Login");
                LoginBtn.setVisibility(View.VISIBLE);
                Register.setVisibility(View.VISIBLE);
                RegisterBtn.setVisibility(View.GONE);
                Login.setVisibility(View.GONE);
            }
        });
    }
}
