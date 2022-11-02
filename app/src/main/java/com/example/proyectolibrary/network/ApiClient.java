package com.example.proyectolibrary.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://192.168.20.25/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
