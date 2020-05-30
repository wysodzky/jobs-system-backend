package com.example.jobs.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class HelloWorldController {
    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String firstPage(){
        return "sucess";
    }
}
