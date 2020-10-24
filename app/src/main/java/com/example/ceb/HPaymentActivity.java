package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class HPaymentActivity extends AppCompatActivity {

    TextView first,second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hpayment);

        getSupportActionBar().setTitle("Payment");

        first = (TextView) findViewById(R.id.textView1);
        second = (TextView) findViewById(R.id.textView10);

        first.setText(Html.fromHtml("Date &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160  2020-10-02 <br> Amount  &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160   Rs 1800.00 <br> Payment Mode &nbsp;&nbsp;&nbsp;&nbsp &#160 &nbsp;&nbsp;&nbsp;&nbsp &#160 &nbsp;&nbsp;&nbsp;&nbsp &#160 &nbsp;&nbsp;&nbsp;&nbsp &#160 &#160 &#160 Cash <br> Place &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &#160 - "));
        second.setText(Html.fromHtml("Date   &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160    2020-09-02 <br> Amount  &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 Rs 2000.00 <br> Payment Mode &nbsp;&nbsp;&nbsp;&nbsp &#160 &nbsp;&nbsp;&nbsp;&nbsp &#160 &nbsp;&nbsp;&nbsp;&nbsp &#160 &nbsp;&nbsp;&nbsp;&nbsp &#160 &#160 &#160 Cash <br> Place  &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &nbsp;&nbsp;&nbsp;&nbsp &#160 - "));
    }
}
