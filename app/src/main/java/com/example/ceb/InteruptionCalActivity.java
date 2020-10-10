package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InteruptionCalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interuption_cal);

        getSupportActionBar().setTitle("Interruption Calender");
    }
}
