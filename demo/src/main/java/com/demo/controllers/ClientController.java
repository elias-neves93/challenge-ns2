package com.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "client")

public class ClientController {

    @GetMapping("/teste")
    public String test() {

        return "Test!";
    }
}
