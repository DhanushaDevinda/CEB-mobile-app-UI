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
        mySpinner = (Spinner) findViewById(R.id.spinner1);

        days_layout.setVisibility(LinearLayout.GONE);
        units_per_day_layout.setVisibility(LinearLayout.GONE);
        units_layout.setVisibility(LinearLayout.VISIBLE);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView t_price = findViewById(R.id.tariff_price);
        TextView f_charge = findViewById(R.id.fixed_charge);

        if(mySpinner.getSelectedItem().toString().equals("Domestic")){
            t_price.setText("Rs."+getResources().getString(R.string.tariff_value, 11)+".00");
            f_charge.setText("Rs."+getResources().getString(R.string.fixed_charge, 540)+".00");
        }if(mySpinner.getSelectedItem().toString().equals("Domestic TOU")){
            t_price.setText("Rs."+getResources().getString(R.string.tariff_value, 13)+".00");
            f_charge.setText("Rs."+getResources().getString(R.string.fixed_charge, 540)+".00");
        }if(mySpinner.getSelectedItem().toString().equals("Industrial")){
            t_price.setText("Rs."+getResources().getString(R.string.tariff_value, 21)+".00");
            f_charge.setText("Rs."+getResources().getString(R.string.fixed_charge, 600)+".00");
        }if(mySpinner.getSelectedItem().toString().equals("General")){
            t_price.setText("Rs."+getResources().getString(R.string.tariff_value, 31)+".00");
            f_charge.setText("Rs."+getResources().getString(R.string.fixed_charge, 240)+".00");
        }if(mySpinner.getSelectedItem().toString().equals("Government")){
            t_price.setText("Rs."+getResources().getString(R.string.tariff_value, 33)+".00");
            f_charge.setText("Rs."+getResources().getString(R.string.fixed_charge, 600)+".00");
        }if(mySpinner.getSelectedItem().toString().equals("Hotel")){
            t_price.setText("Rs."+getResources().getString(R.string.tariff_value, 41)+".00");
            f_charge.setText("Rs."+getResources().getString(R.string.fixed_charge, 600)+".00");
        }if(mySpinner.getSelectedItem().toString().equals("Religious & Charity")){
            t_price.setText("Rs."+getResources().getString(R.string.tariff_value, 51)+".00");
            f_charge.setText("Rs."+getResources().getString(R.string.fixed_charge, 30)+".00");
        }if(mySpinner.getSelectedItem().toString().equals("Select Type")) {
            t_price.setText("Rs."+getResources().getString(R.string.tariff_value, 00)+".00");
            f_charge.setText("Rs."+getResources().getString(R.string.fixed_charge, 00)+".00");
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
