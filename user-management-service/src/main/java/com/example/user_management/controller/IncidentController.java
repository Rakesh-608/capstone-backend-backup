package com.example.user_management.controller;

import com.example.user_management.converter.Converter;
import com.example.user_management.domain.Incident;
import com.example.user_management.dto.IncidentDto;
import com.example.user_management.service.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/incidents")
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentController {

    private final IncidentService incidentService;
    private final Converter converter;

    public IncidentController(IncidentService incidentService, Converter converter) {
        this.incidentService = incidentService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<?> getAllIncidents(){
        List<IncidentDto> incidents = new ArrayList<>();
        for(Incident incident: incidentService.getAllIncidents()) {
            incidents.add(converter.convertToIncidentDto(incident));
        }
        return ResponseEntity.ok(incidents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncidentById(String id){
        return ResponseEntity.ok(incidentService.getIncidentById(id));
    }

    @PostMapping
    public ResponseEntity<?> createIncident(IncidentDto incidentDto){
        return ResponseEntity.ok(incidentService.createIncident(converter.convertToIncident(incidentDto)));
    }
}
