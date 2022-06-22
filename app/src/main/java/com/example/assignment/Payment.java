package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Payment extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText paymentID, amount, date, tax;
    Button btnCreatePayment, btnViewPayment, btnTax, btnHome, btnSettings, btnLogout;
    private TextView dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        paymentID = findViewById(R.id.etPaymentID);
        amount = findViewById(R.id.etAmount);
        date = findViewById(R.id.etDate);
        tax = findViewById(R.id.etTax);
        btnCreatePayment = findViewById(R.id.btn_CreatePayment);
        btnViewPayment = findViewById(R.id.btn_ViewPayment);
        dateDisplay = findViewById(R.id.txtDate);

        btnTax = findViewById(R.id.btn_Tax);
        btnHome = findViewById(R.id.btn_Home);
        btnSettings = findViewById(R.id.btn_Settings);
        btnLogout = findViewById(R.id.btn_Logout);
        DBHandlerPayment db = new DBHandlerPayment(Payment.this);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment.this, LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(Payment.this,"You have been logout!",Toast.LENGTH_LONG).show();
            }
        });

        btnTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment.this, Tax.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment.this, Settings.class);
                startActivity(intent);
            }
        });

        //------------------------------------------payment------------------------------------
        btnCreatePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p = paymentID.getText().toString();
                String a = amount.getText().toString();
                String d = dateDisplay.getText().toString();
                String t = tax.getText().toString();


                if (p.equals("") || a.equals("") || d.equals("") || t.equals(""))
                {
                    Toast.makeText(Payment.this, "Please enter all fields", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Payment.this, "Successfully create payment!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), PaymentDetailActivity.class));
                    db.insertPaymentDetails(p, a, d, t);
                }


            }
        });

        btnViewPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PaymentDetailActivity.class));
            }
        });

        findViewById(R.id.clDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        String date = dayOfMonth + "/" + month + "/" + year;
        dateDisplay.setText(date);
    }
}