package com.javaguides.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.javaguides.clientapp.SecondServerProxy;
import com.javaguides.model.CalculatedResult;
import com.javaguides.repository.CalculatedResultRepository;

@Service
public class CalculationServiceFactory {
    private final SecondServerProxy secondServerProxy;
    private final CalculatedResultRepository calculatedResultRepository;
    private static final Logger logger = LoggerFactory.getLogger(CalculationServiceFactory.class);


    @Autowired
    public CalculationServiceFactory(SecondServerProxy secondServerProxy,
                              CalculatedResultRepository calculatedResultRepository) {
        this.secondServerProxy = secondServerProxy;
        this.calculatedResultRepository = calculatedResultRepository;
    }

    public CalculationService createCalculationService() {
        logger.info("Creating a new instance of CalculationService");

        return new CalculationService(secondServerProxy, calculatedResultRepository);
    }
    
}

