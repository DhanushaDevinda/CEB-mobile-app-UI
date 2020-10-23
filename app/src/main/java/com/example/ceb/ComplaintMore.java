package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ComplaintMore extends AppCompatActivity {

    TextView ETmobile;
    TextView ETland;
    TextView ETmore;
    TextView ETloca;
    TextView ETname;
    TextView ETtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_more);

        ETloca = (TextView) findViewById(R.id.textViewlocation);
        ETname = (TextView) findViewById(R.id.textViewName);
        ETtype = (TextView) findViewById(R.id.textViewType);

         ETmobile = (TextView) findViewById(R.id.textViewMobile);
         ETland = (TextView) findViewById(R.id.textViewLand);
         ETmore = (TextView) findViewById(R.id.textViewMore);

        Intent i = getIntent();
        String name = i.getStringExtra("Accname");
        String type = i.getStringExtra("Ctype");
        String location  = i.getStringExtra("Acclocation");
        String mobile =i.getStringExtra("Amobile");
        String land = i.getStringExtra("Aland");
        String more = i.getStringExtra("Amore");

        ETmobile.setText(mobile);
        ETland.setText(land);
        ETmore.setText(more);
        ETloca.setText(location);
        ETname.setText(name);
        ETtype.setText(type);

    }
}
