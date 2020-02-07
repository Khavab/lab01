package com.nomanishibli.lab01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    boolean started = false;
    int count = 0;
    TextView counter;
    Button increase;
    Timer t = new Timer();

    ConstraintLayout bg;

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
        int temp1 = (int) (Math.random() * 256);
        int temp2 = (int) (Math.random() * 256);
        int temp3 = (int) (Math.random() * 256);
        bg.setBackgroundColor(Color.rgb(temp1, temp2, temp3));
        Log.d("deb", "it worked i think");
    }

    public void increaser(View view) {
        increase = findViewById(R.id.increase);
        started = !started;

        if(started)
            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    count += count;
                }
            }, 1000, 1000);

        else
            t.cancel();
    }




}
