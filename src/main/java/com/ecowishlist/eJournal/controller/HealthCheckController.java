package com.ecowishlist.eJournal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String healthCheck()
    {
        return "Health Check: Status - OK.";
    }
}
