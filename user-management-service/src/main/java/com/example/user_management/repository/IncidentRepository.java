package com.example.user_management.repository;

import com.example.user_management.domain.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends MongoRepository<Incident, String>{
    List<Incident> findByUserId(String userId);
}
