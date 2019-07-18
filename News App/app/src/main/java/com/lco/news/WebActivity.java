package com.lco.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web =  findViewById(R.id.wv);
        Intent i = getIntent();
        String con = i.getStringExtra("description");
        web.loadDataWithBaseURL("", con,"text/html","UTF-8","");
    }
}
