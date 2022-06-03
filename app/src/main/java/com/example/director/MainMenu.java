package com.example.director;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    public EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        editText = (EditText) findViewById(R.id.search);
    }

    public void search(View view) {
        findViewById(R.id.search).setVisibility(View.VISIBLE);
        findViewById(R.id.address).setVisibility(View.INVISIBLE);
        findViewById(R.id.addressStr).setVisibility(View.INVISIBLE);
        findViewById(R.id.krest).setVisibility(View.VISIBLE);
    }

    public void clear(View view) {
        findViewById(R.id.search).setVisibility(View.INVISIBLE);
        findViewById(R.id.address).setVisibility(View.VISIBLE);
        findViewById(R.id.addressStr).setVisibility(View.VISIBLE);
        findViewById(R.id.krest).setVisibility(View.INVISIBLE);
        editText.getText().clear();
    }

    public void address(View view) {
        Intent intent = new Intent(this, Address.class);
        startActivity(intent);
    }

    public void addressStr(View view) {
        Intent intent = new Intent(this, Address.class);
        startActivity(intent);
    }

    public void food(View view) {
        findViewById(R.id.foodbar).setVisibility(View.VISIBLE);
        findViewById(R.id.drinkbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.snackbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.saucebar).setVisibility(View.INVISIBLE);
    }

    public void drink(View view) {
        findViewById(R.id.foodbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.drinkbar).setVisibility(View.VISIBLE);
        findViewById(R.id.snackbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.saucebar).setVisibility(View.INVISIBLE);
    }

    public void snack(View view) {
        findViewById(R.id.foodbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.drinkbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.snackbar).setVisibility(View.VISIBLE);
        findViewById(R.id.saucebar).setVisibility(View.INVISIBLE);
    }

    public void sauce(View view) {
        findViewById(R.id.foodbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.drinkbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.snackbar).setVisibility(View.INVISIBLE);
        findViewById(R.id.saucebar).setVisibility(View.VISIBLE);
    }
}