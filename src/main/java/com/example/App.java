package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://api.openweathermap.org/data/2.5/weather?lat=37.3688&lon=122.0363&appid=9b2801f09f907db9079c9bcd3bac08f7"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = response.body();
       // System.out.println(result);

        String jsonString = result; // assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        JSONArray weathers = obj.getJSONArray("weather");
        for (int i = 0; i < weathers.length(); i++){
            JSONObject weather = weathers.getJSONObject(i);
            String description = weather.getString("description");  
            System.out.println(description);
        }

    }
}
