package com.sasa.trafficdevilsapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    private static Retrofit ourInstance;

    public static Retrofit getInstance(){
        if(ourInstance == null)
            ourInstance = new Retrofit.Builder()
                    .baseUrl("http://demo7877231.mockable.io/api/v1/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return ourInstance;
    }

    private RetrofitClient(){

    }
}
