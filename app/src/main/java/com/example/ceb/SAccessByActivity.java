package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SAccessByActivity extends AppCompatActivity {

    Button access;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saccess_by);
        getSupportActionBar().setTitle("Access By Censes");

        access = findViewById(R.id.button6);

        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Successfully added into the list",
                        Toast.LENGTH_SHORT);

                toast.show();
            }
        });
    }
}
