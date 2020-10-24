package com.example.ceb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.1.7:3000";
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setTitle("Register");

        final EditText nameEdit = this.findViewById(R.id.editTextUsername);
        final EditText emailEdit = this.findViewById(R.id.email);
        final EditText nicEdit = this.findViewById(R.id.email11);
        final EditText phoneNoEdit = this.findViewById(R.id.email113);

        final EditText UserNameEdit = this.findViewById(R.id.username);

        final EditText passwordEdit = this.findViewById(R.id.password);
        final EditText confirmPasswordEdit = this.findViewById(R.id.cpassword);

        Button RegisterBTN = this.findViewById(R.id.button);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        RegisterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //   System.out.println(passwordEdit.getText().toString());
                //   System.out.println(confirmPasswordEdit.getText().toString());

                if(nameEdit.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext() , "Please Enter Name", Toast.LENGTH_LONG).show();
                }
                else if(emailEdit.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext() , "Please Enter Email", Toast.LENGTH_LONG).show();
                }
                else if(nicEdit.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext() , "Please Enter NIC No", Toast.LENGTH_LONG).show();
                }
                else if(phoneNoEdit.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext() , "Please Enter Mobile No", Toast.LENGTH_LONG).show();
                }
                else if(UserNameEdit.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext() , "Please Enter User name", Toast.LENGTH_LONG).show();
                }
                else if(passwordEdit.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext() , "Please Enter Password", Toast.LENGTH_LONG).show();
                }
                else {
                    if(passwordEdit.getText().toString().equals(confirmPasswordEdit.getText().toString()) ){
                        HashMap<String ,String> map = new HashMap<>();
                        map.put("name", nameEdit.getText().toString());
                        map.put("email", emailEdit.getText().toString());
                        map.put("nic", nicEdit.getText().toString());
                        map.put("phoneNo", phoneNoEdit.getText().toString());
                        map.put("userName", UserNameEdit.getText().toString());
                        map.put("password", passwordEdit.getText().toString());


                        Call<Void> call = retrofitInterface.executesignup(map);

                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {

                                if(response.code() == 200){

                                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                                    intent.putExtra("userName", UserNameEdit.getText().toString());
                                    startActivity(intent);

                                } else if(response.code() == 400){
                                    Toast.makeText(getApplicationContext() , "User Name Already Exits", Toast.LENGTH_LONG).show();
                                }


                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        });

                    } else {
                        Toast.makeText(getApplicationContext() , "Confirm Password Does Not Match!!!", Toast.LENGTH_LONG).show();
                    }

                }



            }
        });

    }
}
