package com.example.director;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Address extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);
    }

    public void addressOk(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        Toast.makeText(this,"Адрес сохранен",Toast.LENGTH_SHORT);
    }

    public void addressBack(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}
