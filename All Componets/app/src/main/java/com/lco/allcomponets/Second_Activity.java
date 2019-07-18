package com.lco.allcomponets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
            Bundle bundle =getIntent().getExtras();
            String name =bundle.getString("name");
            String email =bundle.getString("email");
            Toast.makeText(getApplicationContext(),name+" "+email,Toast.LENGTH_SHORT).show();
            WebView web =findViewById(R.id.wv);
            web.loadUrl("file:///android_asset/index.html");
            web.setWebViewClient(new WebViewClient());
        }

}
