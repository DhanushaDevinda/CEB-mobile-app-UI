package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HConfirmPaymentActivity extends AppCompatActivity {

    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hconfirm_payment);

        getSupportActionBar().setTitle("Confirm Payment Details");

        pay = findViewById(R.id.button4);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HConfirmPaymentActivity.this, PaymentProcessActivity.class);
                startActivity(intent);
            }
        });
    }
}
