package com.lco.dialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnStar;
    Button btnZero;
    Button btnHash;
    Button btnDelete;
    Button btnDial;
    Button btnmsg;
    Button btnwhatsapp;

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.buttonOne);
        btnTwo = findViewById(R.id.buttonTwo);
        btnThree = findViewById(R.id.buttonThree);
        btnFour = findViewById(R.id.buttonFour);
        btnFive = findViewById(R.id.buttonFive);
        btnSix = findViewById(R.id.buttonSix);
        btnSeven = findViewById(R.id.buttonSeven);
        btnEight = findViewById(R.id.buttonEight);
        btnNine = findViewById(R.id.buttonNine);
        btnStar = findViewById(R.id.buttonStar);
        btnZero = findViewById(R.id.buttonZero);
        btnHash = findViewById(R.id.buttonHash);
        btnDelete = findViewById(R.id.buttonDelete);
        btnDial = findViewById(R.id.call);
        btnmsg = findViewById(R.id.msg);
        btnwhatsapp = findViewById(R.id.whatsapp);

        input = findViewById(R.id.editText);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no=input.getText().toString();

                makePhoneCall(no);
            }
        });


        btnwhatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, welcome to my application ");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            }
        });

        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

    }

    private void makePhoneCall(String d) {


       Intent in =new Intent(Intent.ACTION_CALL);
       in.setData(Uri.parse("tel:"+d));
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {

            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(d)));
        }
    }


    public void one(View v) {
        onButtonClick(btnOne, input, "1");
    }

    public void two(View v) {
        onButtonClick(btnTwo, input, "2");
    }

    public void three(View v) {
        onButtonClick(btnThree, input, "3");
    }

    public void four(View v) {
        onButtonClick(btnFour, input, "4");
    }

    public void five(View v) {
        onButtonClick(btnFive, input, "5");
    }

    public void six(View v) {
        onButtonClick(btnSix, input, "6");
    }

    public void seven(View v) {
        onButtonClick(btnSeven, input, "7");
    }

    public void eight(View v) {
        onButtonClick(btnEight, input, "8");
    }

    public void nine(View v) {
        onButtonClick(btnNine, input, "9");
    }

    public void star(View v) {
        onButtonClick(btnStar, input, "*");
    }

    public void zero(View v) {
        onButtonClick(btnZero, input, "0");
    }

    public void hash(View v) {
        onButtonClick(btnHash, input, "#");
    }


    public void onDelete(View v) {
        input.setText("");
    }

    public void onButtonClick(Button button, EditText inputNumber, String number) {
        String cache = input.getText().toString();
        inputNumber.setText(cache + number);
    }
}