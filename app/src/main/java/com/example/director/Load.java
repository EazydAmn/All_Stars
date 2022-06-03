package com.example.director;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class Load extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                runOnUiThread(() -> {
                    Intent intent = new Intent(this, BeforeLoginScreen.class);
                    startActivity(intent);
                    finish();
                });
            } catch (InterruptedException e){
                e.getStackTrace();
            }
        }).start();
    }
}
