package com.bekir.business.dto.pojo;

import java.util.ArrayList;
import java.util.List;

public class Forecast {
    private List<Forecastday> forecastday = new ArrayList<Forecastday>();

    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }
}
