package com.example.user_management.clients;

import com.example.user_management.dto.AddressDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="address-service", url = "http://localhost:8200")
public interface AddressDetailsClient {

    @GetMapping("/getAddressByCoordinates")
    public AddressDetailsDto getLocation(@RequestParam double latitude, @RequestParam double longitude);

}
