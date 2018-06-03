package com.example.asus.firebaseuploadexample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.firebaseuploadexample.login.Register;

public class Start extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_start );

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        new Handler ().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Start.this, Register.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
