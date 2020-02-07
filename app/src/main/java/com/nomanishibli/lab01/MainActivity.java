package com.nomanishibli.lab01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

import android.os.Handler;
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
    final Handler h = new Handler();
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


}
