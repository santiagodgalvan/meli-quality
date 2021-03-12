package com.bootcamp.caloriescalculator.services;

import com.bootcamp.caloriescalculator.model.dto.CaloriesCalculatorResponseDTO;
import com.bootcamp.caloriescalculator.model.dto.DishFoodDTO;
import org.springframework.stereotype.Service;

@Service
public interface ICaloriesCalculatorService {

    CaloriesCalculatorResponseDTO calculate(DishFoodDTO plate);
}
