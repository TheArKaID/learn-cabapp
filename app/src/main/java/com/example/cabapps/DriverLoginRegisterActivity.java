package com.example.cabapps;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DriverLoginRegisterActivity extends AppCompatActivity {

    TextView Register;
    TextView Login;
    TextView Title;
    Button RegisterBtn;
    Button LoginBtn;

    EditText EmailET;
    EditText PasswordET;

    FirebaseAuth mAuth;
    ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login_register);

        mAuth = FirebaseAuth.getInstance();

        EmailET = findViewById(R.id.driverEmail);
        PasswordET = findViewById(R.id.driverPassword);
        Register = findViewById(R.id.doRegister);
        Login = findViewById(R.id.doLogin);
        RegisterBtn = findViewById(R.id.driverRegisterBtn);
        LoginBtn = findViewById(R.id.driverLoginBtn);
        Title = findViewById(R.id.textView2);
        loadingBar = new ProgressDialog(this);

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

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = EmailET.getText().toString();
                String pass = PasswordET.getText().toString();

                RegisterDriver(email, pass);
            }
        });
    }

    private void RegisterDriver(String email, String pass) {
        if(TextUtils.isEmpty(email)){
            Toast.makeText(DriverLoginRegisterActivity.this,"Please Write an Email", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(DriverLoginRegisterActivity.this, "Please write a Password.....", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Driver Registration");
            loadingBar.setMessage("Please wait, We are Registering you.....");
            loadingBar.show();
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(DriverLoginRegisterActivity.this, "Register Successfully....", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(DriverLoginRegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                    }
                    loadingBar.dismiss();
                }
            });
        }
    }
}
