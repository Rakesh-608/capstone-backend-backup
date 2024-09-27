package com.example.location_service.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDetails {
    private String name;
    private String country;
    private String state;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

