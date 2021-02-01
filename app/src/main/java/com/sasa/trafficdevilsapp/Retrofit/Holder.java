package com.sasa.trafficdevilsapp.Retrofit;

import com.sasa.trafficdevilsapp.Retrofit.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Holder {
    @GET("hot")
    Call<List<String>> getTrend();

    @GET("post/{id}")
    Call<Data> getType(@Path("id") String id);
}
