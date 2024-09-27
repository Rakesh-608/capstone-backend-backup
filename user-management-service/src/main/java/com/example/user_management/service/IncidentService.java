package com.example.user_management.service;

import com.example.user_management.domain.Incident;
import com.example.user_management.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public Incident createIncident(Incident  incident) {
       return incidentRepository.save(incident);
    }

    public Incident getIncidentById(String id) {
        return incidentRepository.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
    }

    public Iterable<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident updateIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public void deleteIncident(String id) {
        incidentRepository.deleteById(id);
    }

    public List<Incident> getIncidentsByUserId(String userId) {
        return incidentRepository.findByUserId(userId);
    }
}
