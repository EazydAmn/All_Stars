package com.example.director;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class BeforeLoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_login_screen);
    }
    public double x1;
    public double x2;
    public double y1;
    public double y2;

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch (touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();

                if ((x1>x2)&((y2<=y1+100)&(y2>=y1-100))){
                    Intent intent = new Intent(this,LoginScreenWithInternet.class);
                    startActivity(intent);
                }
                break;
        }
        return false;
    }
}