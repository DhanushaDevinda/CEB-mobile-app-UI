package com.example.ceb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class NewComplaintActivity extends AppCompatActivity {
Button complaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_complaint);

        getSupportActionBar().setTitle("New Complaint");

        complaint = findViewById(R.id.button3);

        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(NewComplaintActivity.this);

                builder.setTitle("Complaint received Successfully");
                builder.setMessage("Your complaint received Successfully!");

                builder.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        Intent intent = new Intent(NewComplaintActivity.this, MainActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });



                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
