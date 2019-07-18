package com.lco.runtimepermission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.app.Activity;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   Button btn1,btn2;
   private static final int CAMERA_REQUEST=50;
   private static final int INTERNET_REQUEST=51;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.enable);
        btn2 = findViewById(R.id.enableall);
    }
    btn1.setOnClickListener(new View.OnClickListener()
    {

        public void onClick (View view){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]
        (Manifest.permission.SEND_SMS), INTERNET_REQUEST);
    }
    }
    btn2.SetonClickListener(new View.OnClickListener(){
        public void onClick (View view){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]
            (Manifest.permission.CAMERA,Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE).
            CAMERA_REQUEST;
        }
    }
}
