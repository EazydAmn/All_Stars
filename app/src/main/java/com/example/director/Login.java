package com.example.director;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Queue;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void pashem(View view) throws JSONException {
        String password = ((TextView)findViewById(R.id.password)).getText().toString().trim();
        String email = ((TextView)findViewById(R.id.email)).getText().toString().trim();

        String url = "https://food.madskill.ru/auth/login";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email",email);
        jsonObject.put("password",password);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,url,jsonObject,result ->{
            Toast.makeText(this, "Успешный вход", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainMenu.class);
            startActivity(intent);
            }, error->{
            Toast.makeText(this, "Неверные данные", Toast.LENGTH_SHORT).show();
        });
        requestQueue.add(request);
    }

}