package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Unit test for simple App.
 */
public class WeatherApiTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        Dotenv dotenv = Dotenv.configure()
        .directory("./").load();
        String APP_ID = dotenv.get("APP_ID");

        WeatherApi weather = new WeatherApi(APP_ID);
        String results[] = weather.getWeather(37.3688, 122.0363);
        assertTrue(results.length == 1);
        // TODO: if tomorrow rains, this is false; we need to write a better test
        assertTrue(results[0].equals("clear sky"));
    }
}
