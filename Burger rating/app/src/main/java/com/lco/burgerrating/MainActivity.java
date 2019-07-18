package com.lco.burgerrating;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView textView;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnrating();
        btnsubmit=findViewById(R.id.s);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListnerOnsubmit();
            }
        });
    }

public void addListenerOnrating() {
    ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    textView = (TextView) findViewById(R.id.textView3);

    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            textView.setText(String.valueOf(v));
        }
    });
}
public void addListnerOnsubmit() {

    float ratingValue = ratingBar.getRating();
    if (ratingValue < 2){
        textView.setText("Rating : " + ratingValue + "\nSorry!! We will try better next time");
    }
    else if (ratingValue <=3 ){
        textView.setText("Rating : " + ratingValue + "\n We are constantly improving");
    }
    else {
        textView.setText("Rating : "+ ratingValue +"\n Thnak You!! Visit again,bye!!");
    }

}
}