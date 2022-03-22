package com.mafiaz.currencyconverter.api;

public class RespondData {
    private String result;
    private String time_last_update_utc;
    private double conversion_rate;
    private double conversion_result;

    public RespondData(){ }

    public RespondData(String status, String last_update_date, double converted_rate, double converted_result){
        this.result = status;
        this.time_last_update_utc = last_update_date;
        this.conversion_rate = converted_rate;
        this.conversion_result = converted_result;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public String getStatus() {
        return result;
    }
}
