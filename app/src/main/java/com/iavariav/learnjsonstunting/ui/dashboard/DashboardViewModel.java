package com.iavariav.learnjsonstunting.ui.dashboard;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.iavariav.learnjsonstunting.model.StuntingModel;
import com.iavariav.learnjsonstunting.rest.ApiConfig;
import com.iavariav.learnjsonstunting.rest.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends ViewModel {

    private static final String TAG = "retrofit";
    private MutableLiveData<List<StuntingModel>> listMutableLiveData;


    public LiveData<List<StuntingModel>> getStunding(){
        if (listMutableLiveData == null){
            listMutableLiveData = new MutableLiveData<List<StuntingModel>>();

            laodDataTraining();
        }

        return listMutableLiveData;
    }

    private void laodDataTraining() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData().enqueue(new Callback<ArrayList<StuntingModel>>() {
            @Override
            public void onResponse(Call<ArrayList<StuntingModel>> call, Response<ArrayList<StuntingModel>> response) {
                if (response.isSuccessful()){
                    listMutableLiveData.setValue(response.body());
                    Log.d(TAG, "onResponse: " + response.body());
                } else {
                    Log.d(TAG, "onResponseFail: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<StuntingModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage() + " || " + t.getLocalizedMessage());
            }
        });
    }
}