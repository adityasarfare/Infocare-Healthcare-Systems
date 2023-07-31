package com.server2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondServerController {
	
    private static final Logger logger = LoggerFactory.getLogger(SecondServerController.class);

    @PostMapping("/multiply")
    public double multiply(@RequestParam("num1") double num1,
                           @RequestParam("num2") double num2) {
        logger.info("Received multiplication request for num1: {} and num2: {}", num1, num2);

        return num1 * num2;
        
    }
}

