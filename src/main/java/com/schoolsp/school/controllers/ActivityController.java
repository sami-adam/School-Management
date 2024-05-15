package com.schoolsp.school.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @GetMapping("/activities")
    @PreAuthorize("hasRole('USER')")
    public String getActivities(){
        String url = "https://www.boredapi.com/api/activity";
        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.getForObject(url, String.class);

        return res;
    }
}
