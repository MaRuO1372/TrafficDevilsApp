package com.sasa.trafficdevilsapp.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("payload")
    @Expose
    private Payload payload;

    public String getType() {
        return type;
    }

    public Payload getPayload() {
        return payload;
    }

}