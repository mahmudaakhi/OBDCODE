package com.akhi.obdcodeerror;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MyRetrofit {
@GET("/android/connect.php")
        Call<List<CarList>>getUser();
        @GET("/android/Search.php")
        Call<List<CarList>>getSearch();
        @GET("/android/akhi.php")
        Call<List<CarList>>getCode();

}
