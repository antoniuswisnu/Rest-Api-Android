package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("beers")
    Call<Beers> getRandomBeer();

    @GET("beers")
    Call<List<Beers>> getBeers(@Query("size") int number);

    @GET("users")
    Call<List<Users>> getUsers();

    @GET("users/{id}")
    Call<Users> getUsers(@Path("id") int id);

}