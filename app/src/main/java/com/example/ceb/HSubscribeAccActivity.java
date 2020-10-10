package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HSubscribeAccActivity extends AppCompatActivity {

    Button bill,pay,lbill,accdelete,paym;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsubscribe_acc);

        getSupportActionBar().setTitle("Subscribe Account");
      bill =   findViewById(R.id.bills);
      pay  =  findViewById(R.id.paynow);
      lbill =  findViewById(R.id.lastbill);
      accdelete =  findViewById(R.id.accdelete);
      paym = findViewById(R.id.payment);

      bill.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
               Intent intent = new Intent(HSubscribeAccActivity.this, HElectricityBillActivity.class);
               startActivity(intent);
          }
      });

      pay.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(HSubscribeAccActivity.this, InstanceBillActivity.class);
              startActivity(intent);
          }
      });

      lbill.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(HSubscribeAccActivity.this, HLastBillActivity.class);
              startActivity(intent);
          }
      });

      paym.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(HSubscribeAccActivity.this, HPaymentActivity.class);
              startActivity(intent);
          }
      });
    }
}
