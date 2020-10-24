package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HSubscribeAccActivity extends AppCompatActivity {

    Button bill,pay,lbill,accdelete,paym,subs;
    TextView details;
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
      subs = findViewById(R.id.button6);
      details = (TextView) findViewById(R.id.subscribe_details);

      details.setText(Html.fromHtml("Acc No : 4690224245 <br> Acc Name : Home <br> Name and Address : <br> Kethaki Padmaperuma, <br> no:115, <br>  Dampe road, <br> Meegoda."));

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

      subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HSubscribeAccActivity.this, HSubscriptionAccActivity.class);
                startActivity(intent);
            }
      });
    }
}
