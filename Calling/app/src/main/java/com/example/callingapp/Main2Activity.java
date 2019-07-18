package com.example.callingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button buttonSend;
    EditText textPhoneNo;
    EditText textSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


            buttonSend = (Button) findViewById(R.id.send);
            textPhoneNo = (EditText) findViewById(R.id.pno);
            textSMS = (EditText) findViewById(R.id.msg);

            buttonSend.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    String phoneNo = textPhoneNo.getText().toString();
                    String sms = textSMS.getText().toString();

                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                        Toast.makeText(getApplicationContext(), "SMS Sent!",
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(),
                                "SMS faild, please try again later!",
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                }
            });
        }
    }

