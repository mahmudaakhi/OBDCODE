package com.akhi.obdcodeerror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchDetailActivity extends AppCompatActivity {
    private static final String URL = "http://obderrorcode.com/";
    String query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);
        //query er code ta k amra ekhne ene rekhe dilam
        Intent intent = getIntent();
        query = intent.getStringExtra("query");
        getSearch(query);
    }
    private void getSearch(String query) {
        //Retrofit.....
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRetrofit retrofit1 = retrofit.create(MyRetrofit.class);
        Call<List<Model>> call = retrofit1.getSearch(query);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                ShowList(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
            }
        });
    }
    private void ShowList(List<Model> body) {
        Log.e("Error", String.valueOf(body.size()));
    }
}