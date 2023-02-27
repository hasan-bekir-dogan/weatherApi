package com.bekir.business.services;

import com.bekir.business.dto.WeatherDto;

import java.util.Map;

public interface WeatherServices {
    public WeatherDto getWeatherDaily(String location);
    public Map<String, WeatherDto> getWeatherWeekly(String location);
    public Map<String, WeatherDto> getWeatherMonthly(String location);
}
