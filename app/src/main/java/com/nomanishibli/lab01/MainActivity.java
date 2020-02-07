package com.nomanishibli.lab01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import android.os.Handler;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean started = false;
    int count = 0;
    TextView counter;
    Button increase;
    final Handler h = new Handler();
    ConstraintLayout bg;
    Button tryToPressMe;
    int r, g, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = findViewById(R.id.textBox);
        bg = findViewById(R.id.background);
        increase = findViewById(R.id.increase);
    }


    public void changeColor(View view) {
        bg = findViewById(R.id.background);
        r = (int) (Math.random() * 256);
        g = (int) (Math.random() * 256);
        b = (int) (Math.random() * 256);
        bg.setBackgroundColor(Color.rgb(r, g, b));
        Log.d("deb", "it worked i think");
    }

    public void increaser(View view) {
        increase = findViewById(R.id.increase);
        counter = findViewById(R.id.textBox);
        started = !started;

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(started) {
                    count += 1;
                    counter.setText("Started: " + count);
                    h.postDelayed(this, 1000);
                }
                else
                    counter.setText(("Stopped: " + count));

            }
        }, 1000);
    }

    public void move(View view){
        tryToPressMe = findViewById(R.id.tryToPressMe);
        float xPos = Resources.getSystem().getDisplayMetrics().widthPixels - tryToPressMe.getWidth();
        float yPos = Resources.getSystem().getDisplayMetrics().heightPixels - tryToPressMe.getHeight() - 250;

        tryToPressMe.setX((float) (Math.random() * xPos));
        tryToPressMe.setY((float) (Math.random() * yPos));

    }


}
