package com.example.api;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
//        tv2 = findViewById(R.id.tv2);
//        getRandomData();
        getRandomBeers();
//        getSpecifiedUser();

    }

    private void getRandomData(){
        Call<Beers> caller = RetrofitClient.getInstance().getMyApi().getRandomBeer();

        caller.enqueue(new Callback<Beers>() {
            @Override
            public void onResponse(Call<Beers> call, Response<Beers> response) {
                Beers randomBeer = response.body();
                tv1.setText(randomBeer.getMerk());

            }

            @Override
            public void onFailure(Call<Beers> call, Throwable t) {

            }
        });

    }

    private void getRandomBeers() {
        Call<List<Beers>> caller = RetrofitClient.getInstance().getMyApi().getBeers(2);
        caller.enqueue(new Callback<List<Beers>>() {
            @Override
            public void onResponse(Call<List<Beers>> call, Response<List<Beers>> response) {
                List <Beers> beersList = response.body();
                String beers = "";
                for (int i = 0; i<beersList.size();i++) {
                    Beers curentBeer = beersList.get(i);
                    beers = beers + String.valueOf(curentBeer.getBeerID()) + " ";
                    beers = beers + curentBeer.getNama() + ", ";
                    beers = beers + curentBeer.getMerk() + ", ";
                }

                tv1.setText(beers);
            }

            @Override
            public void onFailure(Call<List<Beers>> call, Throwable t) {

            }
        });


    }

    private void getSpecifiedUser(){
        Call<Users> call = RetrofitClient.getInstance().getMyApi().getUsers(12);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Users user = response.body();
                tv1.setText(user.getName());
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }






}