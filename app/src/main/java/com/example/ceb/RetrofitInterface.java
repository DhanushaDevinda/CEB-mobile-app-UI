package com.example.ceb;

import com.example.ceb.Model.AccessByCensuModel;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/login")
    Call<Void> executeLogin(@Body HashMap<String, String> map);

    @POST("/signup")
    Call<Void> executesignup(@Body HashMap<String, String> map);

    @POST("/getAccessByCensus")
    Call<List<AccessByCensuModel>> executegetAccess(@Body HashMap<String, String> map);


    @POST("/addAccessByCensus")
    Call<AccessByCensuModel> executeAddAccess(@Body HashMap<String, String> map);

}
