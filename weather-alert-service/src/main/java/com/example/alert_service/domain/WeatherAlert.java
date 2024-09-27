package com.example.alert_service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherAlert {

    private double lat;
    private double lon;
    private String timezone;
    private String cityName;
    private String stateCode;
    private String countryCode;
    private List<Alert> alerts;
}
