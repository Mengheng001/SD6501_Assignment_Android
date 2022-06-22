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
import java.util.HashMap;

public class UpdatePaymentActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    Bundle intentBundle;
    int pID;
    TextView txtPaymentID;
    EditText etAmount, etDate, etTax;
    Button btnUpdate, btnDelete;
    TextView dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_payment);

        intentBundle = getIntent().getExtras();
        pID = intentBundle.getInt("PID");

        DBHandlerPayment db = new DBHandlerPayment(this);
        HashMap<String, String> payment = db.getSinglePayment(pID);

        txtPaymentID= findViewById(R.id.txtPaymentID);
        etAmount = findViewById(R.id.etAmount);
        dateDisplay = findViewById(R.id.etDate);

        etTax = findViewById(R.id.etTax);

        txtPaymentID.setText(payment.get("paymentID"));
        etAmount.setText(payment.get("etAmount"));
        dateDisplay.setText(payment.get("dateDisplay"));
        etTax.setText(payment.get("etTax"));


        findViewById(R.id.txtDate).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
    public void updatePayment(View view) {

        DBHandlerPayment db = new DBHandlerPayment(UpdatePaymentActivity.this);

        String am = etAmount.getText().toString();
        String da = dateDisplay.getText().toString();
        String ta = etTax.getText().toString();

        db.updatePaymentDetails(pID, am, da, ta);

        Toast.makeText(this, "Payment has been successfully updated!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), PaymentDetailActivity.class));
    }

    public void deletePayment(View view) {

        DBHandlerPayment db = new DBHandlerPayment(UpdatePaymentActivity.this);
        db.deletePayment(pID);

        Toast.makeText(this, "Payment has been successfully deleted!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), PaymentDetailActivity.class));
    }


}