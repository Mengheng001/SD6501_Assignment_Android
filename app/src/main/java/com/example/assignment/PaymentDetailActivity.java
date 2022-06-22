package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class PaymentDetailActivity extends AppCompatActivity {

    ListView listView;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);

        DBHandlerPayment db = new DBHandlerPayment(this);
        ArrayList<HashMap<String, String>> paymentList = db.getAllPayment();

        listView = findViewById(R.id.paymentList);
        btnBack = findViewById(R.id.btnBack);

        ListAdapter adapter = new SimpleAdapter(PaymentDetailActivity.this,paymentList, R.layout.list_row, new String[]{"paymentID", "amount",
                "date", "tax"},
                new int[]{R.id.paymentID, R.id.amount, R.id.date, R.id.tax});

        listView.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Payment.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), UpdatePaymentActivity.class);

                HashMap<String, String> paymentObj = (HashMap<String, String>) adapter.getItem(i);

                int tempID = Integer.valueOf(paymentObj.get("id"));

                Bundle extra = new Bundle();
                extra.putInt("PID", tempID);
                intent.putExtras(extra);
                startActivity(intent);
            }
        });
    }

}