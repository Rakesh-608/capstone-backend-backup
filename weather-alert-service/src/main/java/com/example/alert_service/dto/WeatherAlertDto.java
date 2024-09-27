package com.example.alert_service.dto;

import com.example.alert_service.domain.Alert;

import java.util.List;

public record WeatherAlertDto(
        double lat,
        double lon,
        String timezone,
        String cityName,
        String stateCode,
        String countryCode,
        List<AlertDto> alerts
) {}

