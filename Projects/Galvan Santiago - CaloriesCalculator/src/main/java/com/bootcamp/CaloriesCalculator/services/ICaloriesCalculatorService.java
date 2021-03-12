package com.bootcamp.CaloriesCalculator.services;

import com.bootcamp.CaloriesCalculator.model.dto.CaloriesCalculatorResponseDTO;
import com.bootcamp.CaloriesCalculator.model.dto.FoodPlateDTO;
import org.springframework.stereotype.Service;

@Service
public interface ICaloriesCalculatorService {

    CaloriesCalculatorResponseDTO calculate(FoodPlateDTO plate);
}
