package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

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
            mainlayout.setVisibility(LinearLayout.VISIBLE);
        }
        else {
            mainlayout.setVisibility(LinearLayout.GONE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
