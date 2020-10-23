package com.example.ceb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class NewComplaintActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button complaint;
    RadioGroup radioGroup;
    Spinner mySpinner1;
    Spinner mySpinner2;

    String location;
    String name;
    String type;
    String mobile;
    String land;
    String more;

    EditText ETmobile;
    EditText ETland;
    EditText ETmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_complaint);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mySpinner1 = (Spinner) findViewById(R.id.spinnerName);
        mySpinner1.setOnItemSelectedListener(this);

        ETmobile = (EditText) findViewById(R.id.editTextMobile);
        ETland = (EditText) findViewById(R.id.editTextLand);
        ETmore = (EditText) findViewById(R.id.editTextMore);


        mySpinner2 = (Spinner) findViewById(R.id.spinnerType);
        mySpinner2.setOnItemSelectedListener(this);

        getSupportActionBar().setTitle("New Complaint");

        complaint = findViewById(R.id.button3);

        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mobile = ETmobile.getText().toString();
                land = ETland.getText().toString();
                more = ETmore.getText().toString();

                if(ETland.getText().toString().isEmpty() ||ETmobile.getText().toString().isEmpty() ){
                    ETland.setError("All filed required");
                }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(NewComplaintActivity.this);

                builder.setTitle("Complaint received Successfully");
                builder.setMessage("Your complaint received Successfully!");

                builder.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        Intent intent = new Intent(NewComplaintActivity.this, ComplaintListActivity.class);
                        intent.putExtra("Accname",name);
                        intent.putExtra("Acclocation",location);
                        intent.putExtra("Ctype",type);
                        intent.putExtra("Amobile",mobile);
                        intent.putExtra("Aland",land);
                        intent.putExtra("Amore",more);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });



                AlertDialog alert = builder.create();
                alert.show();
            }
        }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        name = mySpinner1.getSelectedItem().toString();
        type =  mySpinner2.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onRadioButtonClicked(View view) {

        switch (view.getId()) {
            case R.id.radioButtonEleAcc:
                location = "Electricity Account";
                break;
            case R.id.radioButtonShow:
                location = "Show on Map";
                break;
        }

        Toast.makeText(this, location, Toast.LENGTH_SHORT).show();
    }
}
