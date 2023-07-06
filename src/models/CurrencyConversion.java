package models;

import http.ApiClient;
import org.json.JSONObject;

public class CurrencyConversion extends Conversion{

    @Override
    public double cover(double amount,String original_value,String target_value) {
        this.amount = amount;
        this.original_value = original_value;
        this.target_value = target_value;
        return 0;
    }

    public JSONObject getData(double amount,String original_value,String target_value){
        ApiClient apiClient = new ApiClient();

        String value = String.valueOf(amount);
        String response = apiClient.getCurrencyExchangeRate(value,original_value,target_value);
        JSONObject jsonObject = new JSONObject(response);
        return jsonObject;
    }
}
