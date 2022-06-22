package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ViewDeveloperActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_developer);

        webView=findViewById(R.id.viewDeveloper);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.facebook.com/people/Mengheng-Han/100011168943673/");
    }
}