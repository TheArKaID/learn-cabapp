package com.example.cabapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DriverLoginRegisterActivity extends AppCompatActivity {

    TextView Register;
    TextView Login;
    TextView Title;
    Button RegisterBtn;
    Button LoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login_register);

        Register = findViewById(R.id.doRegister);
        Login = findViewById(R.id.doLogin);
        RegisterBtn = findViewById(R.id.driverRegisterBtn);
        LoginBtn = findViewById(R.id.driverLoginBtn);
        Title = findViewById(R.id.textView2);

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
