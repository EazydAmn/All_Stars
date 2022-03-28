package com.example.maket2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void kino(View view) {
        Intent intent = new Intent(this, Film.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}