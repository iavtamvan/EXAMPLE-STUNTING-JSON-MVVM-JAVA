package com.iavariav.learnjsonstunting.rest;

import com.iavariav.learnjsonstunting.model.StuntingModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("exec?action=read&sheetName=materi") //end point
    Call<ArrayList<StuntingModel>> getData();

    @GET("exec?") //end point
    Call<ArrayList<StuntingModel>> getDatabyQuery(@Query("action") String action,
                                                  @Query("sheetName") String sheetname);

}


