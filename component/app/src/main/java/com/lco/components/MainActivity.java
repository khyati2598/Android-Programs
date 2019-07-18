package com.lco.components;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button call,whatsapp,browser,send,third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call =findViewById(R.id.btn1);
        whatsapp = findViewById(R.id.btn3);
        browser = findViewById(R.id.btn2);
        send = findViewById(R.id.btn4);
        third = findViewById(R.id.btn5);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencall();
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openwhatsapp();
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senddata();
            }
        });
//        third.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                three();
//            }
//        });
    }
    private void opencall()
    {
        Intent  intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:8769654070"));
        startActivity(intent);
    }
    private void openbrowser()
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.google.com"));
        startActivity(i);
    }
    private void openwhatsapp()
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "hello welcome to android studio");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }
    private void senddata()
    {
        Intent i =  new Intent(this, SecondActivity.class);
        i.putExtra("name","khyati");
        i.putExtra("emai","guptakhyati25@gmail.com");
        startActivity(i);
    }
    //private void three()
}
