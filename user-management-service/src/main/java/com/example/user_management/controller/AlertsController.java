package com.example.user_management.controller;


import com.example.user_management.clients.AlertClient;
import com.example.user_management.dto.AlertDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alerts")
@CrossOrigin(origins = "http://localhost:4200")
public class AlertsController {
    private final AlertClient alertClient;

    public AlertsController(AlertClient alertClient) {
        this.alertClient = alertClient;
    }

    @GetMapping
    public ResponseEntity<?> viewAlerts(Double latitude, Double longitude){
        List<AlertDto> alertDtos = alertClient.getWeatherAlerts(latitude, longitude);
        return ResponseEntity.ok(alertDtos);
    }
}
