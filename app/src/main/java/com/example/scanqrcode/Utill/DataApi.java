package com.example.scanqrcode.Utill;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataApi {
    public static final String BASE_URL="http://192.168.238.178/";
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