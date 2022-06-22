package com.example.assignment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnPayment, btnTax, btnSettings, btnLogout;
    TextView tvOutputPayment;


    DBHandlerPayment dbHandlerPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandlerPayment = new DBHandlerPayment(this);

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        btnLogout = findViewById(R.id.btn_Logout);
        tvOutputPayment = findViewById(R.id.tv_outputPayment);
        btnPayment = findViewById(R.id.btn_Payment);
        btnTax = findViewById(R.id.btn_Tax);
        btnSettings = findViewById(R.id.btn_Settings);


        tvOutputPayment.setText(String.format("Your Total Payment Amount is: $%s", dbHandlerPayment.getSumPayment()));



        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(MainActivity.this,"You have been logout!",Toast.LENGTH_LONG).show();
            }
        });


        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Payment.class);
                startActivity(intent);
            }
        });

        btnTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Tax.class);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });


    }


}