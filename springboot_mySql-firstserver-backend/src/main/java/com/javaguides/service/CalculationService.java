package com.javaguides.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.javaguides.clientapp.SecondServerProxy;
import com.javaguides.exception.CalculationException;
import com.javaguides.model.CalculatedResult;
import com.javaguides.repository.CalculatedResultRepository;

@Service
public class CalculationService {
    private final SecondServerProxy secondServerProxy;
    private final CalculatedResultRepository calculatedResultRepository;
    private static final Logger logger = LoggerFactory.getLogger(CalculationService.class);


    @Autowired
    public CalculationService(SecondServerProxy secondServerProxy,
                              CalculatedResultRepository calculatedResultRepository) {
        this.secondServerProxy = secondServerProxy;
        this.calculatedResultRepository = calculatedResultRepository;
    }

    public double multiply(double num1, double num2) {
        logger.info("Performing multiplication for {} and {}", num1, num2);
        
        if (num1 == 0 || num2 == 0) {
            throw new CalculationException("Both numbers must be non-zero for multiplication.");
        }

        double result = secondServerProxy.multiply(num1, num2);
         
        logger.info("Multiplication result: {}", result);

        // Save the result in the database
        CalculatedResult calculatedResult = new CalculatedResult();
        calculatedResult.setNum1(num1);
        calculatedResult.setNum2(num2);
        calculatedResult.setResult(result);
        calculatedResultRepository.save(calculatedResult);

        return result;
    }
}

