package com.akhi.obdcodeerror;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

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
    private static final String BASE_URL = URL + "android/Search.php";

    TextView search;
    String[] item;
    RecyclerView recyclerView;
    Adapter adapter;
    List<CarList> carLists = new ArrayList<>();
    CodeAdapter codeAdapter;
    private Menu tool;


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
        Call<List<Model>> call = retrofit1.getCode();
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
        codeAdapter = new CodeAdapter(this, body);
        recyclerView.setAdapter(codeAdapter);
    }

    //------search er jonno/-------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) tool.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchContact("users", query);
                return false;
            }

            private void fetchContact(String users, String query) {
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchContact("users", newText);
                return false;
            }
        });
        return true;
    }
}



        