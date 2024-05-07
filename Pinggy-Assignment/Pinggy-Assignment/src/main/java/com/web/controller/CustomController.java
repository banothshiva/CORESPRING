package com.web.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.filter.CustomAuthFilter;

@RestController
public class CustomController {

    @GetMapping("/")
    public String getAuthHeaderValue() {
        String authHeader = CustomAuthFilter.getAuthHeader();
        if (authHeader != null) {
            return "Auth Header Value: " + authHeader;
        } else {
            return "No Auth Header Found!";
        }
    }
}
