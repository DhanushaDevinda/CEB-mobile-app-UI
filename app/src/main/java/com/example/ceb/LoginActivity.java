package com.example.ceb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    Button login;
    TextView regster;

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.168.1.7:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        login = findViewById(R.id.button);
        regster = findViewById(R.id.textViewRegister);

        final EditText userNameEdit = this.findViewById(R.id.editTextUsername);

        final EditText passwordEdit = this.findViewById(R.id.editTextPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String ,String> map = new HashMap<>();
                map.put("userName", userNameEdit.getText().toString());
                map.put("password", passwordEdit.getText().toString());

                Call<LoginResults> call = retrofitInterface.executeLogin(map);

                call.enqueue(new Callback<LoginResults>() {
                    @Override
                    public void onResponse(Call<LoginResults> call, Response<LoginResults> response) {

                        if(response.code() == 200){

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);


                        } else if(response.code() == 404){
                            Toast.makeText( getApplicationContext(), "Email or Password does not match.", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResults> call, Throwable t) {

                        Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });



            }
        });

        regster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
