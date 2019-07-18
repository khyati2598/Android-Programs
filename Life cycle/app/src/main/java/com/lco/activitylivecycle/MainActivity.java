package com.lco.activitylivecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"create",Toast.LENGTH_SHORT).show();
//        find_id();
        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"intent",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });
    }
@Override
protected void onStart() {
    super.onStart();
    Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT).show();
}
@Override
protected void onStop() {
    super.onStop();
    Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
}
@Override
protected void onResume() {
    super.onResume();
    Toast.makeText(MainActivity.this, "Resume", Toast.LENGTH_SHORT).show();
}
//protected void find_id()
//{
//    b1 =findViewById(R.id.button);
//}
}