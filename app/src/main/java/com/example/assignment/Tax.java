package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tax extends AppCompatActivity {

    Button btnPayment, btnHome, btnSettings, btnLogout;
    TextView tvOutputTax;

    DBHandlerPayment dbHandlerPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);

        dbHandlerPayment = new DBHandlerPayment(this);

        tvOutputTax = findViewById(R.id.tv_outputTax);
        btnPayment = findViewById(R.id.btn_Payment);
        btnHome = findViewById(R.id.btn_Home);
        btnSettings = findViewById(R.id.btn_Settings);
        btnLogout = findViewById(R.id.btn_Logout);

        tvOutputTax.setText(String.format("Your Total Tax Amount is: $%s", dbHandlerPayment.getSumTax()));


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tax.this, LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(Tax.this,"You have been logout!",Toast.LENGTH_LONG).show();
            }
        });

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tax.this, Payment.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tax.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tax.this, Settings.class);
                startActivity(intent);
            }
        });

    }
}