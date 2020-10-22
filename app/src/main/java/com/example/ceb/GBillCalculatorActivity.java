package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class GBillCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    LinearLayout days_layout;
    LinearLayout units_per_day_layout;
    LinearLayout units_layout;
    Spinner mySpinner;

    int num_of_days = 0;
    int num_of_units_per_day = 0;
    int num_of_units = 0;

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

    //hide and visible layouts when radio button changes
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

    //increasing & decreasing value of number of days
    public void increase_nod(View view) {
        num_of_days = num_of_days + 1;
        display_nod(num_of_days);
    }
    public void decrease_nod(View view) {
        num_of_days--;
        if(num_of_days < 0){
            num_of_days = 0;
        }
        display_nod(num_of_days);
    }
    private void display_nod(int number) {
        TextView value = (TextView) findViewById(R.id.no_of_days);
        value.setText("" + number);
    }

    //increasing & decreasing value of number of units per day
    public void increase_noupd(View view) {
        num_of_units_per_day = num_of_units_per_day + 1;
        display_noupd(num_of_units_per_day);
    }
    public void decrease_noupd(View view) {
        num_of_units_per_day--;
        if(num_of_units_per_day < 0){
            num_of_units_per_day = 0;
        }
        display_noupd(num_of_units_per_day);
    }
    private void display_noupd(int number) {
        TextView value = (TextView) findViewById(R.id.no_of_units_per_day);
        value.setText("" + number);
    }

    //increasing & decreasing value of number of units
    public void increase_nou(View view) {
        num_of_units = num_of_units + 1;
        display_nou(num_of_units);
    }
    public void decrease_nou(View view) {
        num_of_units--;
        if(num_of_units < 0){
            num_of_units = 0;
        }
        display_nou(num_of_units);
    }
    private void display_nou(int number) {
        TextView value = (TextView) findViewById(R.id.no_of_units);
        value.setText("" + number);
    }

}
