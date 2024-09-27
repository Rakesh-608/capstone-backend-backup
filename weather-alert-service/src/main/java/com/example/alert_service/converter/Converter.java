package com.example.alert_service.converter;

import com.example.alert_service.domain.Alert;
import com.example.alert_service.domain.WeatherAlert;
import com.example.alert_service.dto.AlertDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {
/*
//    public WeatherAlert  convertToWeatherAlert(WeatherAlertDto weatherAlertDto) {
//        WeatherAlert = new WeatherAlert();
//        weatherAlert.setLat(weatherAlertDto.lat());
//        weatherAlert.setLon(weatherAlertDto.lon());
//        weatherAlert.setTimezone(weatherAlertDto.timezone());
//        weatherAlert.setAlerts(this.convertToAlert(weatherAlertDto.alerts()));
//        weatherAlert.setCityName(weatherAlertDto.cityName());
//        weatherAlert.setCountryCode(weatherAlertDto.countryCode());
//        weatherAlert.setStateCode(weatherAlertDto.stateCode());
//
//        return weatherAlert;
//    }

    public WeatherAlertDto convertToWeatherAlertDto(WeatherAlert weatherAlert) {
        return new WeatherAlertDto(
                weatherAlert.getLat(),
                weatherAlert.getLon(),
                weatherAlert.getTimezone(),
                weatherAlert.getAlerts(),
                weatherAlert.getCityName(),
                weatherAlert.getCountryCode(),
                weatherAlert.getStateCode()
        );
    }
   */

    public List<Alert> extractAlertsFromWeatherAlert(WeatherAlert weatherAlert) {
        List<Alert> alertList = new ArrayList<>();
        for (Alert a : weatherAlert.getAlerts()) {
            Alert alert = new Alert();
            alert.setTitle(a.getTitle());
            alert.setDescription(a.getDescription());
            alert.setSeverity(a.getSeverity());
            alert.setEffectiveUtc(a.getEffectiveUtc());
            alert.setEffectiveLocal(a.getEffectiveLocal());
            alert.setExpiresUtc(a.getExpiresUtc());
            alert.setExpiresLocal(a.getExpiresLocal());
            alert.setOnsetUtc(a.getOnsetUtc());
            alert.setOnsetLocal(a.getOnsetLocal());
            alert.setUri(a.getUri());
            alert.setEndsUtc(a.getEndsUtc());
            alert.setEndsLocal(a.getEndsLocal());
            alert.setRegions(a.getRegions());
            alertList.add(alert);
        }
        return alertList;
    }

    public List<AlertDto> convertToAlertDtoList(List<Alert> alertList) {
        List<AlertDto> alertDtoList = new ArrayList<>();
        for (Alert alert : alertList) {
            AlertDto alertDto = new AlertDto(
                    alert.getTitle(),
                    alert.getDescription(),
                    alert.getSeverity(),
                    alert.getEffectiveUtc(),
                    alert.getEffectiveLocal(),
                    alert.getExpiresUtc(),
                    alert.getExpiresLocal(),
                    alert.getOnsetUtc(),
                    alert.getOnsetLocal(),
                    alert.getUri(),
                    alert.getEndsUtc(),
                    alert.getEndsLocal(),
                    alert.getRegions()
            );
            alertDtoList.add(alertDto);
        }
        return alertDtoList;
    }

}
