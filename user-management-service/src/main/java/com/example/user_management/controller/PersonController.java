package com.example.user_management.controller;


import com.example.user_management.clients.AddressDetailsClient;
import com.example.user_management.clients.AlertClient;
import com.example.user_management.converter.Converter;
import com.example.user_management.domain.Person;
import com.example.user_management.dto.AlertDto;
import com.example.user_management.dto.LoginRequest;
import com.example.user_management.dto.PersonDto;
import com.example.user_management.dto.UserResponse;
import com.example.user_management.service.PersonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    private final PersonService personService;
    private final AlertClient alertClient;
    private final AddressDetailsClient addressDetailsClient;
    private final Converter converter;

    public PersonController(PersonService personService, AlertClient alertClient, AddressDetailsClient addressDetailsClient, Converter converter) {
        this.personService = personService;
        this.alertClient = alertClient;
        this.addressDetailsClient = addressDetailsClient;
        this.converter = converter;
    }


    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        // Validate email and password (for demo purposes, we're using hardcoded values)
        if (personService.existsByEmailAndPassword(loginRequest.email(), loginRequest.password())) {
            // Create a new session if one doesn't exist
            Person user=personService.getUserByEmailAndPassword(loginRequest.email(),loginRequest.password());
            HttpSession session = request.getSession(true);
            session.setAttribute("user", loginRequest.email());
            log.info("User logged in: {}", loginRequest.email());
            return ResponseEntity.ok(new UserResponse(user.getId(), user.getEmail()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/is-logged-in")
    public ResponseEntity<Boolean> isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody PersonDto personDto){
        Person person = converter.convertToPerson(personDto);
        return ResponseEntity.ok(personService.saveUser(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        Person person = personService.getUserById(id);
        PersonDto  personDto = converter.convertToPersonDto(person);
        return ResponseEntity.ok(personDto);
    }

    @GetMapping("/viewDashboard")
    public ResponseEntity<?> viewDashboard(){
        return ResponseEntity.ok("viewDashboard");
    }

    @GetMapping("/viewProfile")
    public ResponseEntity<Person> viewProfile(@PathVariable String id){
        return ResponseEntity.ok(personService.getUserById(id));
    }

    @GetMapping("/viewAlerts")
    public ResponseEntity<?> viewAlerts(Double latitude, Double longitude){
        List<AlertDto> alertDtos = alertClient.getWeatherAlerts(latitude, longitude);
        return ResponseEntity.ok(alertDtos);
    }

    @GetMapping("/viewAccidentReports")
    public ResponseEntity<?> viewAccidentReports(){
        return ResponseEntity.ok("viewAccidentReports");
    }

    @PostMapping("/postAnIncident")
    public ResponseEntity<?> postAnIncident(){
        return ResponseEntity.ok("postAnIncident");
    }

    @PostMapping("/sendAlertToResponders")
    public ResponseEntity<?> sendAlertToResponders(){
        return ResponseEntity.ok("sendAlertToResponders");
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<?> updateProfile(){
        return ResponseEntity.ok("updateProfile");
    }

    @GetMapping("/getWeatherAlerts")
    public ResponseEntity<?> getWeatherAlerts(@RequestParam Double latitude, @RequestParam Double longitude){
        return ResponseEntity.ok(alertClient.getWeatherAlerts(latitude,longitude));
    }

    @GetMapping("/getAddressByCoordinates")
    public ResponseEntity<?> getAddressByCoordinates(@RequestParam Double latitude, @RequestParam Double longitude){
        return ResponseEntity.ok(addressDetailsClient.getLocation(latitude, longitude));
    }
}
