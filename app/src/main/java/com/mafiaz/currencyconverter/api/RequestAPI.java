package com.mafiaz.currencyconverter.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestAPI {

    private final static String base_url = "https://v6.exchangerate-api.com";

    private final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ExchangeRateAPI getRequest(){
        return retrofit.create(ExchangeRateAPI.class);
    }
}
