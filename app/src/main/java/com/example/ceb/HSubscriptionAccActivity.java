package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HSubscriptionAccActivity extends AppCompatActivity {
 Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsubscription_acc);

        getSupportActionBar().setTitle("Subscription Account");

        pay = findViewById(R.id.button6);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HSubscriptionAccActivity.this, HConfirmPaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}
