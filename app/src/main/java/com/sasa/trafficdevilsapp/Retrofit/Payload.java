package com.sasa.trafficdevilsapp.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("url")
    @Expose
    private String url;

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }
}
