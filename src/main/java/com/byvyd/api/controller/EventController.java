package com.byvyd.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/event")
@ApiIgnore
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
