package com.example.maket2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void nazad_log(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void nazad_reg(View view) throws JSONException {
        Intent intent = new Intent(this, Login.class);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String name = ((TextView) findViewById(R.id.name)).getText().toString().trim();
        String surname = ((TextView) findViewById(R.id.surname)).getText().toString().trim();
        String email = ((TextView) findViewById(R.id.email)).getText().toString().trim();
        String password = ((TextView) findViewById(R.id.password)).getText().toString().trim();
        String repassword = ((TextView) findViewById(R.id.repassword)).getText().toString().trim();

        String url = "http://cinema.areas.su/auth/register";
        if ((name.isEmpty()) || (surname.isEmpty()) || (email.isEmpty()) || (password.isEmpty()) || (repassword.isEmpty())){
            Toast.makeText(this, "Поля не заполнены", Toast.LENGTH_LONG).show();
        }else if (password.equals(repassword)) {
            JSONObject json = new JSONObject();

            json.put("email", email);
            json.put("password", password);
            json.put("firstName", name);
            json.put("lastName", surname);
            final String requestBody = json.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                    Log.println(Log.INFO,"Log in", "Успешный вход");
                    startActivity(intent);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };
            requestQueue.add(stringRequest);
        } else {
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
        }
    }
}