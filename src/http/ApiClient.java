package http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiClient {

    private static final String API_BASE_URL;
    private static final String API_KEY;

    static {
        Properties properties = new Properties();
        try {
            InputStream inputStream = ApiClient.class.getClassLoader().getResourceAsStream("config.properties");
            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            } else {
                throw new IOException("Could not find config.properties file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        API_BASE_URL = properties.getProperty("API_BASE_URL");
        API_KEY = properties.getProperty("API_KEY");
    }


    public static String getCurrencyExchangeRate(String amount, String baseCurrency, String targetCurrency) {
        String endpoint = API_BASE_URL + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency + "/" + amount;
        return HttpService.sendGetRequest(endpoint);
    }
}
