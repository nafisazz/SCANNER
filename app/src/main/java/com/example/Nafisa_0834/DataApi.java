package com.example.Nafisa_0834;

import static com.example.Nafisa_0834.ServerAPI.DATA_API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataApi {
    public static final String BASE_URL= DATA_API;
    private static Retrofit retrofit=null;
    public static Retrofit getClient(){
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}