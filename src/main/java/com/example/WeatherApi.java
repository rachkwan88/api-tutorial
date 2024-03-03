package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherApi {
    private String api_key;

    public WeatherApi(String api_key) {
        this.api_key = api_key;

    }

    public String[] getWeather(double lat, double lon) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+this.api_key))
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

        ArrayList<String> descs = new ArrayList<String>();
        for (int i = 0; i < weathers.length(); i++) {
            JSONObject weather = weathers.getJSONObject(i);
            String description = weather.getString("description");
            descs.add(description);
        }
        
        String[] answer = Arrays.copyOf(descs.toArray(), descs.size(), String[].class);
        return answer;

    }
}
