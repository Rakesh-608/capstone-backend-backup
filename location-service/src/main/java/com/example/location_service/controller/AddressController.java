package com.example.location_service.controller;

import com.example.location_service.domain.AddressDetails;
import com.example.location_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {


    private final AddressService locationService;

    public AddressController(AddressService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/getAddressByCoordinates")
    public AddressDetails getLocation(@RequestParam double latitude, @RequestParam double longitude) {
        return locationService.getLocationDetails(latitude, longitude);
    }
}

