package com.example.ceb;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/login")
    Call<Void> executeLogin(@Body HashMap<String, String> map);

    @POST("/signup")
    Call<Void> executesignup(@Body HashMap<String, String> map);


}
