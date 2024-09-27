package com.example.alert_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AlertConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

/*
Creating a web application in Spring Boot to handle emergency requests involves several key components. Below is a high-level overview of how to structure your application along with code snippets to get you started.

### 1. Project Setup

Use Spring Initializr to set up a new Spring Boot project with the following dependencies:
- Spring Web
- Spring Data JPA (if you plan to use a database)
- Thymeleaf (for server-side rendering)
- Spring Boot DevTools (optional)

### 2. Project Structure

Here's a suggested project structure:

```
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── emergency_service
    │               ├── EmergencyServiceApplication.java
    │               ├── controller
    │               │   └── EmergencyController.java
    │               ├── service
    │               │   └── EmergencyService.java
    │               └── model
    │                   └── EmergencyRequest.java
    └── resources
        ├── application.yaml
        ├── templates
        │   └── emergency.html
        └── static
            └── js
                └── emergency.js
```

### 3. Create Model Class

Create a model class to represent the emergency request.

#### EmergencyRequest.java

```java
package com.example.emergency_service.model;

public class EmergencyRequest {
    private String serviceType; // e.g., "Police", "Fire Station"
    private Double latitude;
    private Double longitude;
    private String message; // Optional message from the user

    // Getters and Setters
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
```

### 4. Create Service Class

Create a service class to handle the logic for sending requests to emergency services.

#### EmergencyService.java

```java
package com.example.emergency_service.service;

import com.example.emergency_service.model.EmergencyRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmergencyService {

    private final RestTemplate restTemplate;

    public EmergencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sendEmergencyRequest(EmergencyRequest request) {
        // URL of the emergency service API (replace with actual URLs)
        String url = "https://api.example.com/emergency-services"; // Example URL

        // Send request to the chosen emergency service
        return restTemplate.postForObject(url, request, String.class);
    }
}
```

### 5. Create Controller Class

Create a controller to handle web requests.

#### EmergencyController.java

```java
package com.example.emergency_service.controller;

import com.example.emergency_service.model.EmergencyRequest;
import com.example.emergency_service.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmergencyController {

    @Autowired
    private EmergencyService emergencyService;

    @GetMapping("/emergency")
    public String showEmergencyPage(Model model) {
        model.addAttribute("emergencyRequest", new EmergencyRequest());
        return "emergency"; // Thymeleaf template
    }

    @PostMapping("/request-help")
    public String requestHelp(EmergencyRequest emergencyRequest, Model model) {
        String response = emergencyService.sendEmergencyRequest(emergencyRequest);
        model.addAttribute("response", response);
        return "emergency"; // Redirect or display a response
    }
}
```

### 6. Create Thymeleaf Template

Create a simple HTML form to collect emergency information.

#### emergency.html

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Emergency Services</title>
    <script src="/js/emergency.js"></script>
</head>
<body>
    <h1>Emergency Services</h1>
    <form action="#" th:action="@{/request-help}" th:object="${emergencyRequest}" method="post">
        <label for="serviceType">Choose Service:</label>
        <select id="serviceType" th:field="*{serviceType}">
            <option value="Police">Police</option>
            <option value="Fire Station">Fire Station</option>
            <option value="Ambulance">Ambulance</option>
            <!-- Add more services as needed -->
        </select>

        <input type="hidden" th:field="*{latitude}" id="latitude" />
        <input type="hidden" th:field="*{longitude}" id="longitude" />

        <label for="message">Message:</label>
        <textarea id="message" th:field="*{message}"></textarea>

        <button type="submit">Send Request</button>
    </form>

    <div th:if="${response}">
        <p>Response from service: <span th:text="${response}"></span></p>
    </div>

    <script>
        // Use JavaScript to get the user's location
        navigator.geolocation.getCurrentPosition(function(position) {
            document.getElementById('latitude').value = position.coords.latitude;
            document.getElementById('longitude').value = position.coords.longitude;
        });
    </script>
</body>
</html>
```

### 7. Configure RestTemplate Bean

Add a `RestTemplate` bean to your configuration.

#### AppConfig.java

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

### 8. Application Properties

Make sure you have your `application.yaml` or `application.properties` configured correctly for your needs.

### 9. Testing Your Application

Run your Spring Boot application and navigate to `/emergency` in your browser. The page will allow users to choose an emergency service and send their location and a message.

### Conclusion

This structure provides a solid foundation for your emergency services application. You can expand on this by adding error handling, integrating with real emergency service APIs, and implementing authentication if needed. Let me know if you need more details or further help!
*/

