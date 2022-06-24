package com.shopify.arriv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.facebook.applinks.AppLinkData;
import com.orhanobut.hawk.Hawk;

public class MainActivity extends AppCompatActivity {
    public static final String APLNK_CONJOINED = "apLnkConj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appLinko();

        SharedPreferences prefs = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if (prefs.getBoolean("activity_exec", false)) {
            Intent intent = new Intent(this, Mover.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor exec = prefs.edit();
            exec.putBoolean("activity_exec", true);
            exec.commit();
        }
    }

    public void appLinko() {


        AppLinkData.fetchDeferredAppLinkData(this,
                appLinkData -> {

                    if (appLinkData != null) {


                        String str = String.valueOf(appLinkData.getTargetUri());
                        String[] res = str.split("\\?");

                        String paramFinale = res[1];


                        Hawk.put(APLNK_CONJOINED, paramFinale);


                        Log.d("FB TEST TAG RES: ", paramFinale);


                        startActivity(new Intent(getApplicationContext(), Mover.class));
                        finish();


                    } else {
                        Log.d("FB", "Error Code:");
                        startActivity(new Intent(getApplicationContext(), Mover.class));
                        finish();

                    }

                }
        );
    }
}
