package com.akhi.obdcodeerror;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home  extends AppCompatActivity {
    private static final String URL = "http://obderrorcode.com/";

    RecyclerView recyclerView;
    Adapter adapter;
    List<CarList> carLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//Retrofit.....
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyRetrofit retrofit1 = retrofit.create(MyRetrofit.class);
        Call<List<CarList>> call = retrofit1.getUser();
        call.enqueue(new Callback<List<CarList>>() {
            @Override
            public void onResponse(Call<List<CarList>> call, Response<List<CarList>> response) {
                showList(response.body());

            }

            @Override
            public void onFailure(Call<List<CarList>> call, Throwable t) {

            }
        });
    }

    private void showList(List<CarList> body) {
            Log.e("Profile",String.valueOf(body.size()));
            adapter=new Adapter(this,body);
            recyclerView.setAdapter(adapter);

        }
    }


        