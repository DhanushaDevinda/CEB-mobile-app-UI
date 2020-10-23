package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ComplaintListActivity extends AppCompatActivity {
    private View viewContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);

        getSupportActionBar().setTitle("Complaint List");
        ListView l = (ListView) findViewById(R.id.listview);

        Intent i = getIntent();
        String name = i.getStringExtra("Accname");
        String type = i.getStringExtra("Ctype");
        String location  = i.getStringExtra("Acclocation");
        String mobile =i.getStringExtra("Amobile");
        String land = i.getStringExtra("Aland");
        String more = i.getStringExtra("Amore");

        Property p1 = new Property(location, type,name, "Aldeniya,Kadawatha", land,mobile,more);


        ArrayList<Property> list =new ArrayList<Property>();

        list.add(p1);


        ArrayAdapter<Property> adapter = new propertyArrayAdapter(this, 0, list);
        l.setAdapter(adapter);
    }
}
