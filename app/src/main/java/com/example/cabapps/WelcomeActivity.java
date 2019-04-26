package com.example.cabapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button gotoDriver;
    Button gotoCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        gotoCustomer = (Button) findViewById(R.id.loginCustomerbtn);
        gotoDriver = (Button) findViewById(R.id.loginDriverbtn);

        gotoCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CustomerIntent = new Intent(WelcomeActivity.this, CustomerLoginRegisterActivity.class);
                startActivity(CustomerIntent);
            }
        });

        gotoDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DriverIntent = new Intent(WelcomeActivity.this, DriverLoginRegisterActivity.class);
                startActivity(DriverIntent);
            }
        });
    }
}
