package com.example.location_service.service;

import com.example.location_service.domain.AddressDetails;
import com.example.location_service.domain.OpenCageResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {
    private static final String API_KEY = "c7ff680adaae4af982f6b871e7107d96";
    private static final String API_URL = "https://api.opencagedata.com/geocode/v1/json";

    public AddressDetails getLocationDetails(double latitude, double longitude) {
        String url = String.format("%s?q=%f+%f&key=%s", API_URL, latitude, longitude, API_KEY);
        RestTemplate restTemplate = new RestTemplate();
        OpenCageResponse response = restTemplate.getForObject(url, OpenCageResponse.class);

        if (response != null && response.getResults().length > 0) {
            AddressDetails details = new AddressDetails();
            details.setName(response.getResults()[0].getFormatted());
            details.setCountry(response.getResults()[0].getComponents().getCountry());
            details.setState(response.getResults()[0].getComponents().getState());
            return details;
        }
        return null;
    }
}

