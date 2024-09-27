package com.example.user_management.clients;

import com.example.user_management.dto.AlertDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "alert-service", url = "http://localhost:8300")
public interface AlertClient {

    @GetMapping("/getWeatherAlerts")
    public List<AlertDto> getWeatherAlerts(@RequestParam Double latitude, @RequestParam Double longitude);

}