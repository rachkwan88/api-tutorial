package com.example;

import io.github.cdimascio.dotenv.Dotenv;

public class App {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure()
        .directory("./").load();
        String APP_ID = dotenv.get("APP_ID");

        WeatherApi api = new WeatherApi(APP_ID);
        String descriptions[] = api.getWeather(37.3688, 122.0363);

        for (int i = 0; i < descriptions.length; i++) {
            System.out.println(descriptions[i]);
        }

    }
}
