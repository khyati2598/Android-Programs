package com.lco.components;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String name = getIntent().getStringExtra("name");
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        web = findViewById(R.id.webview);
        web.loadUrl("http://www.google.com");
        web.setWebViewClient(new WebViewClient());
    }
}
