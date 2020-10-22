package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class GBillCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    LinearLayout days_layout;
    LinearLayout units_per_day_layout;
    LinearLayout units_layout;
    Spinner mySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gbill_calculator);

        getSupportActionBar().setTitle("Bill Calculator");

        days_layout = (LinearLayout) this.findViewById(R.id.number_of_days_layout);
        units_per_day_layout = (LinearLayout) this.findViewById(R.id.number_of_units_per_day_layout);
        units_layout = (LinearLayout) this.findViewById(R.id.num_of_units_layout);

        days_layout.setVisibility(LinearLayout.GONE);
        units_per_day_layout.setVisibility(LinearLayout.GONE);
        units_layout.setVisibility(LinearLayout.VISIBLE);

        mySpinner = (Spinner) findViewById(R.id.spinner1);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(mySpinner.getSelectedItem().toString().equals("Domestic")){
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
            TextView price = (TextView)findViewById(R.id.tariff_price);
            price.setText("Rs.00.00");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onRadioButtonClicked(View v)
    {
        boolean  checked = ((RadioButton) v).isChecked();

        switch(v.getId()){
            case R.id.daily:
                if(checked)
                    units_layout.setVisibility(LinearLayout.VISIBLE);
                    days_layout.setVisibility(LinearLayout.GONE);
                    units_per_day_layout.setVisibility(LinearLayout.GONE);
                break;
            case R.id.custom:
                if(checked)
                    units_layout.setVisibility(LinearLayout.GONE);
                    days_layout.setVisibility(LinearLayout.VISIBLE);
                    units_per_day_layout.setVisibility(LinearLayout.VISIBLE);
                break;
        }
    }
}
