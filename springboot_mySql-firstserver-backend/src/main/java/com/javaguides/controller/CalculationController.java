package com.javaguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.javaguides.model.CalculatedResult;
import com.javaguides.service.CalculationService;
import com.javaguides.service.CalculationServiceFactory;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CalculationController {
    private final CalculationServiceFactory calculationServiceFactory;
    
    private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);


    @Autowired
    public CalculationController(CalculationServiceFactory calculationServiceFactory) {
        this.calculationServiceFactory = calculationServiceFactory;
    }
    
    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody CalculatedResult calculatedResult) {
    	
        CalculationService calculationService = calculationServiceFactory.createCalculationService();
        double result = calculationService.multiply(calculatedResult.getNum1(), calculatedResult.getNum2());
        logger.info("Calculation result: {}", result);
        return ResponseEntity.ok(result);
    }
}
