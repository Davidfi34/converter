package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;


public class HttpService {
    public static String sendGetRequest(String ApiUrl) {

        try {

            URL url = new URL(ApiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            //String jsonResponse = response.toString();
            return response.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
    }

}
