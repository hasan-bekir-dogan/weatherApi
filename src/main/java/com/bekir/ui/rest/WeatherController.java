package com.bekir.ui.rest;

import com.bekir.business.dto.WeatherDto;
import com.bekir.business.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

    @Autowired
    WeatherServices weatherServices;

    // http://localhost:8080/api/v1/weather/daily/izmir
    @GetMapping("/weather/daily/{location}")
    public WeatherDto getWeatherDaily(@PathVariable String location) {
        WeatherDto weatherDtoList = weatherServices.getWeatherDaily(location);
        return weatherDtoList;
    }

    // http://localhost:8080/api/v1/weather/weekly/izmir
    @GetMapping("/weather/weekly/{location}")
    public Map<String, WeatherDto> getWeatherWeekly(@PathVariable String location) {
        Map<String, WeatherDto> weatherDtoList = weatherServices.getWeatherWeekly(location);
        return weatherDtoList;
    }

    // http://localhost:8080/api/v1/weather/monthly/izmir
    @GetMapping("/weather/monthly/{location}")
    public Map<String, WeatherDto> getWeatherMonthly(@PathVariable String location) {
        Map<String, WeatherDto> weatherDtoList = weatherServices.getWeatherMonthly(location);
        return weatherDtoList;
    }
}
