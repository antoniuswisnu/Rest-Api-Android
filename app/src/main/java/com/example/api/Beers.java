package com.example.api;

import com.google.gson.annotations.SerializedName;

public class Beers {


    @SerializedName("id")
    private int beerID;

    @SerializedName("name")
    private String nama;

    @SerializedName("brand")
    private String merk;


    public int getBeerID() {
        return beerID;
    }

    public String getNama() {
        return nama;
    }

    public String getMerk() {
        return merk;
    }
}
