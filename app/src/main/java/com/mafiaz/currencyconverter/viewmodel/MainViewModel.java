package com.mafiaz.currencyconverter.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mafiaz.currencyconverter.api.MakeAPICall;
import com.mafiaz.currencyconverter.api.RespondData;

public class MainViewModel extends ViewModel {

    private MutableLiveData<RespondData> result = new MutableLiveData<>();
    private MakeAPICall apiCall;
    private String base_cur;
    private String target_cur;
    private double amount;

    public void setBase_cur(String base_cur) {
        this.base_cur = base_cur;
    }

    public void setTarget_cur(String target_cur) {
        this.target_cur = target_cur;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public MainViewModel(){
        apiCall = new MakeAPICall();

    }

    public MutableLiveData<RespondData> getResult() {
        result = getResultAPI();
        return result;
    }

    private MutableLiveData<RespondData> getResultAPI(){
        return apiCall.getConversionResult(base_cur, target_cur, amount);
    }


}
