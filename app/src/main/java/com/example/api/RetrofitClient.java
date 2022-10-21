package com.example.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private Api myApi;
    private final static String BASE_URL = "https://random-data-api.com/api/v2/";
//    private final static String BASE_URL = "https://gorest.co.in/public/v2/";
    private final static String API_KEY = "Bearer 8c7965bd69cc57560db249f728608f53b96a5ea2f0c75d2e5d237126ae5ad4c7";

    private RetrofitClient(){

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Authorization", API_KEY).build();
                return chain.proceed(request);
            }
        };

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();

        myApi = retrofit.create(Api.class);


    }

    public static synchronized RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getMyApi(){
        return myApi;
    }







}