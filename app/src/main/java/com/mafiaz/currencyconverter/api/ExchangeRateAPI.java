package com.mafiaz.currencyconverter.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ExchangeRateAPI {

    @GET("v6/{api_key}/pair/{base_cur}/{target_cur}/{amount}")
    Call<RespondData> getConvertedData(
            @Path("api_key") String api_key,
            @Path("base_cur") String base_cur,
            @Path("target_cur") String target_cur,
            @Path("amount") int amount
    );
}
