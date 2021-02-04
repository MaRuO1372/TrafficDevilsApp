package com.sasa.trafficdevilsapp.Retrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Holder {
    @GET("hot")
    Call<List<String>> getTrend();

    @GET("post/{id}")
    Call<Data> getType(@Path("id") String id);

    @GET("post/{id}")
    Observable<Data> getNewsData(@Path("id") String id);
}
