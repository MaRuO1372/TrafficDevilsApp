package com.sasa.trafficdevilsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.sasa.trafficdevilsapp.Retrofit.Holder;
import com.sasa.trafficdevilsapp.Retrofit.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        retrofitStart();
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null;
    }

    public void gameStart(){
        Intent intent = new Intent(SplashScreen.this, GameActivity.class);
        startActivity(intent);
        finish();
    }

    public void retrofitStart(){
        //retrofit
        Retrofit retrofit = RetrofitClient.getInstance();
        Holder holder = retrofit.create(Holder.class);
        Call<List<String>> test = holder.getTrend();

        if(isNetworkConnected()) {
            test.enqueue(new Callback<List<String>>() {
                @Override
                public void onResponse(@NotNull Call<List<String>> call, @NotNull Response<List<String>> response) {
                    if (!response.isSuccessful()) {
                        return;
                    }
                    String trends = response.body().toString();
                    String[] name = trends.substring(1).replaceAll("]", "").split(", ");
                    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(name));
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    intent.putStringArrayListExtra("list", arrayList);
                    startActivity(intent);
                    finish();
                }
                @Override
                public void onFailure(@NotNull Call<List<String>> call, @NotNull Throwable t) {
                    Log.d("Main", "Error:" + t.toString());
                    gameStart();
                }
            });
        } else {
            gameStart();
        }
    }
}