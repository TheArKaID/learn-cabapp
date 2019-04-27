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

public class CustomerLoginRegisterActivity extends AppCompatActivity {

    TextView Title;
    TextView Register;
    TextView Login;
    Button RegisterBtn;
    Button LoginBtn;

    EditText EmailET;
    EditText PasswordET;

    FirebaseAuth mAuth;
    ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login_register);

        mAuth = FirebaseAuth.getInstance();

        EmailET = findViewById(R.id.CustomerEmail);
        PasswordET = findViewById(R.id.CustomerPassword);
        Register = findViewById(R.id.doRegister);
        Login = findViewById(R.id.doLogin);
        Title = findViewById(R.id.textView4);
        RegisterBtn = findViewById(R.id.CustomerRegisterBtn);
        LoginBtn = findViewById(R.id.CustomerLoginBtn);
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

                RegisterCustomer(email, pass);
            }
        });

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = EmailET.getText().toString();
                String pass = PasswordET.getText().toString();

                LoginCustomer(email, pass);
            }
        });
    }

    private void LoginCustomer(String email, String pass) {
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Write an Email.....", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Please Write an Password.....", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Customer Sig in");
            loadingBar.setMessage("Please wait, We are signing in you.....");
            loadingBar.show();
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(CustomerLoginRegisterActivity.this, "Login Successfully....", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(CustomerLoginRegisterActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                    loadingBar.dismiss();
                }
            });
        }
    }

    private void RegisterCustomer(String email, String pass) {
        if(TextUtils.isEmpty(email)){
            Toast.makeText(CustomerLoginRegisterActivity.this, "Please Write an Email....", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(CustomerLoginRegisterActivity.this, "Please Write an Password....", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Customer Sig in");
            loadingBar.setMessage("Please wait, We are signing in you.....");
            loadingBar.show();
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(CustomerLoginRegisterActivity.this, "Registration Successfully....", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(CustomerLoginRegisterActivity.this, "Registration Failed....", Toast.LENGTH_SHORT).show();
                    }
                    loadingBar.dismiss();
                }
            });
        }
    }
}
