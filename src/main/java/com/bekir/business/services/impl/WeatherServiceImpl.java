package com.bekir.business.services.impl;

import com.bekir.business.dto.pojo.Forecastday;
import com.bekir.business.dto.pojo.WeatherPojo;
import com.bekir.business.dto.WeatherDto;
import com.bekir.business.services.WeatherServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherServices {
    public final String base_url = "http://api.weatherapi.com/v1";
    public final String api_key = "2c360fb4bc3843c4bca131112232602";

    @Override
    public WeatherDto getWeatherDaily(String location) {
        String date;
        String city;
        String country;
        String condition;

        String uri = base_url + "/forecast.json?key=" + api_key + "&q=" + location;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherPojo> response = restTemplate.getForEntity(uri, WeatherPojo.class);

        date = response.getBody().getCurrent().getLastUpdated();
        city = response.getBody().getLocation().getName();
        country = response.getBody().getLocation().getCountry();
        condition = response.getBody().getCurrent().getCondition().getText();

        WeatherDto dailyWeather = new WeatherDto(city, country, condition);

        return dailyWeather;
    }

    @Override
    public Map<String, WeatherDto> getWeatherWeekly(String location) {
        Map<String, WeatherDto> weeklyWeather = new HashMap<>();
        String date = null;
        String city;
        String country;
        String condition = null;

        String uri = base_url + "/forecast.json?key=" + api_key + "&q=" + location + "&days=7";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherPojo> response = restTemplate.getForEntity(uri, WeatherPojo.class);

        city = response.getBody().getLocation().getName();
        country = response.getBody().getLocation().getCountry();

        List<Forecastday> forecastday = response.getBody().getForecast().getForecastday();

        for (Forecastday element : forecastday) {
            condition = element.getDay().getCondition().getText();
            date = element.getDate();

            WeatherDto weather = new WeatherDto(city, country, condition);

            weeklyWeather.put(date, weather);
        }

        return weeklyWeather;
    }

    @Override
    public Map<String, WeatherDto> getWeatherMonthly(String location) {
        Map<String, WeatherDto> montlyWeather = new HashMap<>();
        String date = null;
        String city;
        String country;
        String condition = null;

        String uri = base_url + "/forecast.json?key=" + api_key + "&q=" + location + "&days=30";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherPojo> response = restTemplate.getForEntity(uri, WeatherPojo.class);

        city = response.getBody().getLocation().getName();
        country = response.getBody().getLocation().getCountry();

        List<Forecastday> forecastday = response.getBody().getForecast().getForecastday();

        for (Forecastday element : forecastday) {
            condition = element.getDay().getCondition().getText();
            date = element.getDate();

            WeatherDto weather = new WeatherDto(city, country, condition);

            montlyWeather.put(date, weather);
        }

        return montlyWeather;
    }
}
