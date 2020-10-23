package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ceb.Model.AccessByCensuModel;
import com.example.ceb.adapter.Adapter;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SAccessByActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.168.1.7:3000";


    private RecyclerView recyclerView;

    private EditText device;
    private EditText qty;
    private EditText hours;
    private EditText power;

    Button access;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saccess_by);
        getSupportActionBar().setTitle("Access By Censes");


        device = findViewById(R.id.device);
        qty = findViewById(R.id.qty);
        hours = findViewById(R.id.hours);
        power = findViewById(R.id.power);


        String username = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");

        }

        recyclerView = findViewById(R.id.listView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        HashMap<String ,String> map = new HashMap<>();
        map.put("device", device.getText().toString());
        map.put("qty", qty.getText().toString());
        map.put("hours", hours.getText().toString());
        map.put("power", power.getText().toString());


        Call<List<AccessByCensuModel>> call = retrofitInterface.executegetAccess(map);

        call.enqueue(new Callback<List<AccessByCensuModel>>() {
            @Override
            public void onResponse(Call<List<AccessByCensuModel>> call, Response<List<AccessByCensuModel>> response) {

                if(response.code() == 200){
                    System.out.println(response.body());
                    if(response.body() != null){
                        Adapter adapter = new Adapter(response.body());
                        recyclerView.setAdapter(adapter);

                        adapter.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText( getApplicationContext(), "No Items in the List", Toast.LENGTH_LONG).show();
                    }




                } else if(response.code() == 404){
                    Toast.makeText( getApplicationContext(), "No Session Started!!!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<AccessByCensuModel>> call, Throwable t) {

                Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        access = findViewById(R.id.button6);

        final String finalUsername = username;
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int quantity = Integer.parseInt(qty.getText().toString());
                Double noOfHours = Double.parseDouble(hours.getText().toString());
                Double powerInt = Double.parseDouble(power.getText().toString());


                Double kwhDay = ((noOfHours * powerInt)/1000 ) * quantity;

                HashMap<String ,String> map = new HashMap<>();
                map.put("device", device.getText().toString());
                map.put("qty", qty.getText().toString());
                map.put("hours", hours.getText().toString());
                map.put("power", power.getText().toString());
                map.put("kDay", kwhDay.toString());

                Call<AccessByCensuModel> call = retrofitInterface.executeAddAccess(map);

                call.enqueue(new Callback<AccessByCensuModel>() {
                    @Override
                    public void onResponse(Call<AccessByCensuModel> call, Response<AccessByCensuModel> response) {

                        if(response.code() == 200){

                            Toast.makeText( getApplicationContext(), "Added to your List", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), SAccessByActivity.class);
                            i.putExtra("username", finalUsername);
                            startActivity(i);

                        } else if(response.code() == 404){
                            Toast.makeText( getApplicationContext(), "You are Offline!!!", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<AccessByCensuModel> call, Throwable t) {

                        Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}
