package com.example.user_management.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public String getAllIncidentReports(){
        return "All Incident Reports";
    }


    public String reviewIncidentReport(){
        return "Review incident Report";
    }


    public String forwardReportToResponders(){
        return "Forward Report to Responders";
    }
}
