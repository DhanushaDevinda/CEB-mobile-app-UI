package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstanceBillActivity extends AppCompatActivity {
Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instance_bill);

        getSupportActionBar().setTitle("Instant Bill Pay");

        pay = findViewById(R.id.button6);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InstanceBillActivity.this, HConfirmPaymentActivity.class);
                startActivity(intent);
            }
        });


    }
}
