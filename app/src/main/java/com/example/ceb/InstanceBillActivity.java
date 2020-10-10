package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InstanceBillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instance_bill);

        getSupportActionBar().setTitle("Instant Bill Pay");
    }
}
