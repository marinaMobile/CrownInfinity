package com.shopify.arriv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        ImageView btn = findViewById(R.id.btn_again);
        btn.setOnClickListener(v -> {
                startActivity(new Intent(getApplicationContext(), Game.class));
                finish();
        });
    }
}