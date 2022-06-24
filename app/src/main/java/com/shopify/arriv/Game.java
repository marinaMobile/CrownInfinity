package com.shopify.arriv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends AppCompatActivity {
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageView dragon = findViewById(R.id.my_button);
        TextView count = findViewById(R.id.click_tv);
        LinearLayout ll_wasp = findViewById(R.id.ll_wasp);

        dragon.setOnClickListener(new View.OnClickListener() {
            int counter = 0;

            @Override
            public void onClick(View v) {
                ++counter;
                count.setText(Integer.toString(counter));
                if (counter == 100) {
                    startActivity(new Intent(getApplicationContext(), Winner.class));
                    finish();
                }
            }
        });
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        dragon.animate()
                                .x(random.nextFloat() * ll_wasp.getWidth())
                                .y(random.nextFloat() * ll_wasp.getHeight())
                                .setDuration(300)
                                .start();
                    }
                });
            }
        },0,300);
    }
}
