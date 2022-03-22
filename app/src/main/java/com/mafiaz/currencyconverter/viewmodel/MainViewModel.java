package com.mafiaz.currencyconverter.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mafiaz.currencyconverter.api.MakeAPICall;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Double> result = new MutableLiveData<>();
    private MakeAPICall apiCall;
    private String base_cur;
    private String target_cur;
    private int amount;

    public void setBase_cur(String base_cur) {
        this.base_cur = base_cur;
    }

    public void setTarget_cur(String target_cur) {
        this.target_cur = target_cur;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public MainViewModel(){
        apiCall = new MakeAPICall();

    }

    public MutableLiveData<Double> getResult() {
        result = getResultAPI();
        return result;
    }

    private MutableLiveData<Double> getResultAPI(){
        return apiCall.getListResult(base_cur, target_cur, amount);
    }


}
