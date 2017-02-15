package com.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nbkf on 31/1/2560.
 */
@RestController
public class HelloController {
    //@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
