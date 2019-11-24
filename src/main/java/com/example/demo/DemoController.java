package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("services")
public class DemoController {
    @Value("${param_name}")
    String param_name;

    @Value("${param.name}")
    String paramName;

    @GetMapping(path = "/hello")
    public String getHello() {
        return "Hello Demo1 success push update - 1. param_name:"+ param_name + " | param.name="+paramName ;
    }
}
