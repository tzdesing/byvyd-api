package com.byvyd.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @GetMapping("/")
    public String findAll(){
        return "heeeello world";
    }

    @GetMapping("/event/{id}")
    public String findById(){
        return "heeeello world";
    }
}
