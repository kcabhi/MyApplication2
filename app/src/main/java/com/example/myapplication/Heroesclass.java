package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Heroesclass {


    @POST("heroes")
    Call<Void> createHeroes(@Body Heroes heroes);

}
