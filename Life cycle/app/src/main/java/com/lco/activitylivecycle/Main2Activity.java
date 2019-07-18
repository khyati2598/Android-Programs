package com.lco.activitylivecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(Main2Activity.this, "create", Toast.LENGTH_SHORT).show();
//        find_id();
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
        @Override
        protected void  onStart () {
            super.onStart();
            Toast.makeText(Main2Activity.this, "on start", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onStop () {
            super.onStop();
            Toast.makeText(Main2Activity.this, "on stop", Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onResume () {
            super.onResume();
            Toast.makeText(Main2Activity.this, "on Resume", Toast.LENGTH_SHORT).show();
        }

//        protected void find_id ()
//        {
//            b2 = findViewById(R.id.button);
//        }
    }
