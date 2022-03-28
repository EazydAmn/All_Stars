package com.example.maket2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registr(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void vhod(View v) throws JSONException {
        String login = ((TextView)findViewById(R.id.login)).getText().toString().trim();
        String password = ((TextView)findViewById(R.id.password)).getText().toString().trim();

        JSONObject json = new JSONObject();
        json.put("email", login);
        json.put("password", password);

        String url = "http://cinema.areas.su/auth/login";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Intent intent  = new Intent(this, MainMenu.class);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, json,
                result -> {
                    Toast.makeText(this, "Успешный вход", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                },
                error -> Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_LONG).show()
        );
        requestQueue.add(request);
    }
}
