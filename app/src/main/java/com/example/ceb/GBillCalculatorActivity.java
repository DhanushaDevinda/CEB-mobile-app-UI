package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class GBillCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    LinearLayout mainlayout;
    Spinner mySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gbill_calculator);

        getSupportActionBar().setTitle("Bill Calculator");

        mainlayout = (LinearLayout) this.findViewById(R.id.numberofunit);
        mySpinner = (Spinner) findViewById(R.id.spinner1);


        mainlayout.setVisibility(LinearLayout.VISIBLE);


        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(mySpinner.getSelectedItem().toString().equals("Domestic")){
            //mainlayout.setVisibility(LinearLayout.VISIBLE);
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.11.00");
        }if(mySpinner.getSelectedItem().toString().equals("Domestic TOU")){
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.13.00");
        }if(mySpinner.getSelectedItem().toString().equals("Industrial")){
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.21.00");
        }if(mySpinner.getSelectedItem().toString().equals("General")){
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.31.00");
        }if(mySpinner.getSelectedItem().toString().equals("Government")){
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.33.00");
        }if(mySpinner.getSelectedItem().toString().equals("Hotel")){
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.41.00");
        }if(mySpinner.getSelectedItem().toString().equals("Religious & Charity")){
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.51.00");
        }if(mySpinner.getSelectedItem().toString().equals("Select Type")) {
            //mainlayout.setVisibility(LinearLayout.GONE);
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.00.00");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
