package com.example.alert_service.controller;

import com.example.alert_service.converter.Converter;
import com.example.alert_service.domain.Alert;
import com.example.alert_service.domain.WeatherAlert;
import com.example.alert_service.dto.AlertDto;
import com.example.alert_service.service.WeatherAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// https://api.weatherbit.io/v2.0/alerts?lat=49.8209&lon=18.2625&key=9b048f06cc0449a095e8bfc3067db3aa
// http://localhost:8080/fetch-alerts?latitude=49.8209&longitude=18.2625

@RestController
public class WeatherAlertController {

    private final WeatherAlertService weatherAlertService;

    private final Converter converter;

    public WeatherAlertController(WeatherAlertService weatherAlertService, Converter converter) {
        this.weatherAlertService = weatherAlertService;
        this.converter = converter;
    }


    @GetMapping("/fetch-alerts")
    public WeatherAlert fetchWeatherAlerts(@RequestParam Double latitude, @RequestParam Double longitude) {
        WeatherAlert alerts = weatherAlertService.getWeatherAlerts(latitude, longitude);
        return alerts; // Return the retrieved alerts
    }

    @GetMapping("/getWeatherAlerts")
    public List<AlertDto> getWeatherAlerts(@RequestParam Double latitude, @RequestParam Double longitude){
        List<Alert> alertsList=converter.extractAlertsFromWeatherAlert(weatherAlertService.getWeatherAlerts(latitude, longitude));
        return converter.convertToAlertDtoList(alertsList);
    }




}
