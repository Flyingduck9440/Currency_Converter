package com.mafiaz.currencyconverter.api;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakeAPICall {
    protected final String API_KEY = "99328966e77f00777d585d2c";

    private MutableLiveData<Double>  listResult = new MutableLiveData<>();
    private ExchangeRateAPI exchangeRateAPI;

    public MakeAPICall(){
        exchangeRateAPI = RequestAPI.getRequest();
    }

    public MutableLiveData<Double> getListResult(String base_cur, String target_cur, int amount){

        Call<RespondData> call = exchangeRateAPI.getConvertedData(API_KEY, base_cur,target_cur,amount);
        call.enqueue(new Callback<RespondData>() {
            @Override
            public void onResponse(Call<RespondData> call, Response<RespondData> response) {
                Log.e("Response",""+response);
                if(response.isSuccessful()){
                    listResult.postValue(response.body().getConversion_result());
                }
            }

            @Override
            public void onFailure(Call<RespondData> call, Throwable t) {
                Log.e("Error",""+t.getMessage());
                listResult.postValue(null);
            }
        });

        return listResult;
    }
}
