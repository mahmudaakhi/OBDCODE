package com.akhi.obdcodeerror;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface MyRetrofit {
@GET("/android/connect.php")
        Call<List<CarList>>getUser();
        @GET("/android/Search.php")
        Call<List<Model>>getSearch(
        @Query("Code_title") String item_type);

        @GET("/android/akhi.php")
        Call<List<Model>>getCode();

}
