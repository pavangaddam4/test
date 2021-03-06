package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("services")
public class DemoController {

    @Value("${param.name}")
    String paramName;

    @GetMapping(path = "/hello")
    public String getHello() {
        return "Demo using jenkins. Version  2. | param.name="+paramName ;
    }
}
