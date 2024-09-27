package com.example.alert_service.service;

import com.example.alert_service.domain.WeatherAlert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherAlertService {

    @Value("${weatherbit.api.key}")
    private String apiKey;

    @Value("${weatherbit.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherAlertService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherAlert getWeatherAlerts(Double latitude, Double longitude) {
        String url = String.format("%s?lat=%f&lon=%f&key=%s", apiUrl, latitude, longitude, apiKey);
        return restTemplate.getForObject(url, WeatherAlert.class);
    }
}
