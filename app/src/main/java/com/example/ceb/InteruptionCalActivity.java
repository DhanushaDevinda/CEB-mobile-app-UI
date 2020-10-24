package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

public class InteruptionCalActivity extends AppCompatActivity {
    DatePicker datePicker;
    Button btn;
    TextView date;
    TextView t_details;
    TextView int_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interuption_cal);

        getSupportActionBar().setTitle("Interruption Calender");

        datePicker = (DatePicker) findViewById(R.id.calendar_date_picker);
        date = (TextView) findViewById(R.id.date_display);
        t_details = (TextView) findViewById(R.id.time_display);
        int_details = (TextView) findViewById(R.id.details_display);

        btn = (Button) findViewById(R.id.cal_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.setText(datePicker.getYear()+"-"+(datePicker.getMonth() + 1)+"-"+datePicker.getDayOfMonth());

                if (date.getText().toString().equals("2020-10-2")){
                    String color_time = "<font color='#000000'>03.00 PM - 05.00 PM</font>";
                    t_details.setText(Html.fromHtml("Power Interruption : "+color_time));
                    int_details.setText("Kotte Rd(portion),U.E. Perera Mw,4th Lane,Velupulliwatta,Seram Mwtta, Obesekarapura(portion) and by roads");
                }
                else if(date.getText().toString().equals("2020-10-6")){
                    String color_time = "<font color='#000000'>08.00 AM - 05.00 PM</font>";
                    t_details.setText(Html.fromHtml("Power Interruption : "+color_time));
                    int_details.setText("Kotuwegoda,Kalapaluwawa Rd,Nelum Pl,Kalapaluwawa 1st Lane, Madinnagoda,M.D.H.Jayawardana Mw,Elhena,Bandaranayakapura (portion),Mahaniyara,Kariyawasam Pl and by roads");
                }
                else if(date.getText().toString().equals("2020-10-8")){
                    String color_time = "<font color='#000000'>08.00 AM - 02.00 PM</font>";
                    t_details.setText(Html.fromHtml("Power Interruption : "+color_time));
                    int_details.setText("Pahala Dodangahahena,Kotikawatta Rd,Baron Perera Mw, Adihena,IDH Rd(portion),Dodangahahena,Bandaranayakapura and by roads");
                }
                else {
                    t_details.setText("");
                    int_details.setText(Html.fromHtml("<big>"+"No Scheduled Interruptions"+"</big>"));
                }
            }
        });


    }

}
