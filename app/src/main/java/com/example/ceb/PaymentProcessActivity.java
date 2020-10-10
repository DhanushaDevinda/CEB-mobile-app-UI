package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PaymentProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_process);

        getSupportActionBar().setTitle("Payment Process");
    }
}
