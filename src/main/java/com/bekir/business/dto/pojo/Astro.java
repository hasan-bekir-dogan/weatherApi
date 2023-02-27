package com.bekir.business.dto.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Astro {
    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;
    private String moonPhase;
    private String moonIllumination;
    private Integer isMoonUp;
    private Integer isSunUp;
    public String getSunrise() {
        return sunrise;
    }
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    public String getSunset() {
        return sunset;
    }
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    public String getMoonrise() {
        return moonrise;
    }
    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }
    public String getMoonset() {
        return moonset;
    }
    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }
    public String getMoonPhase() {
        return moonPhase;
    }
    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }
    public String getMoonIllumination() {
        return moonIllumination;
    }
    public void setMoonIllumination(String moonIllumination) {
        this.moonIllumination = moonIllumination;
    }
    public Integer getIsMoonUp() {
        return isMoonUp;
    }
    public void setIsMoonUp(Integer isMoonUp) {
        this.isMoonUp = isMoonUp;
    }
    public Integer getIsSunUp() {
        return isSunUp;
    }
    public void setIsSunUp(Integer isSunUp) {
        this.isSunUp = isSunUp;
    }
}

