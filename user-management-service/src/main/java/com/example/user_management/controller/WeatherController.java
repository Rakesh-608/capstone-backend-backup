package com.example.user_management.controller;

import com.example.user_management.clients.AlertClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/weather")
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {

    private final AlertClient alertClient;

    public WeatherController(AlertClient alertClient) {
        this.alertClient = alertClient;
    }

    @GetMapping("/getWeatherAlerts")
    public ResponseEntity<?> getWeatherAlerts(@RequestParam Double latitude, @RequestParam Double longitude){
        return ResponseEntity.ok(alertClient.getWeatherAlerts(latitude,longitude));
    }
}
