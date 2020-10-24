package com.example.ceb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class propertyArrayAdapter extends ArrayAdapter<Property>{


    TextView location ;
    TextView complaintType;
    TextView name ;
    TextView address ;
    TextView land ;
    TextView mobile;
    TextView more ;

    private Context context;
    private List<Property> rentalProperties;

    //constructor, call on creation
    public propertyArrayAdapter(Context context, int resource, ArrayList<Property> objects) {
        super(context, resource, objects);

        this.context = context;
        this.rentalProperties = objects;
    }

    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        Property property = rentalProperties.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.simple_complaint_list, null);

Button morebtn = view.findViewById(R.id.buttonmore);


         location = (TextView) view.findViewById(R.id.textViewLocation);
         complaintType = (TextView) view.findViewById(R.id.textViewComplaint);
         name = (TextView) view.findViewById(R.id.textViewName);
         address = (TextView) view.findViewById(R.id.textViewAddress);
         land = (TextView) view.findViewById(R.id.textViewLand);
         mobile = (TextView) view.findViewById(R.id.textViewMobile);
         more = (TextView) view.findViewById(R.id.textViewMore);

        location.setText(property.getLocation());
        complaintType.setText(property.getComplaintType());
        name.setText(property.getName());
        address.setText(property.getAddress());
        land.setText(property.getLand());
        mobile.setText(property.getMobile());
        more.setText(property.getMore());


        morebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context,ComplaintMore.class);
                intent.putExtra("Accname",name.getText().toString());
                intent.putExtra("Acclocation",location.getText().toString());
                intent.putExtra("Ctype",complaintType.getText().toString());
                intent.putExtra("Amobile",mobile.getText().toString());
                intent.putExtra("Aland",land.getText().toString());
                intent.putExtra("Amore",more.getText().toString());
                context.startActivity(intent);
            }
        });
        return view;
    }
}