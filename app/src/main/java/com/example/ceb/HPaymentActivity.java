package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hpayment);

        getSupportActionBar().setTitle("Payment");
    }
}
