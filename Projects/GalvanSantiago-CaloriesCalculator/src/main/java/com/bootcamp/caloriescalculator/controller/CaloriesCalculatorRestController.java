package com.bootcamp.caloriescalculator.controller;

import com.bootcamp.caloriescalculator.model.dto.CaloriesCalculatorResponseDTO;
import com.bootcamp.caloriescalculator.model.dto.DishFoodDTO;
import com.bootcamp.caloriescalculator.services.ICaloriesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesCalculatorRestController {

    @Autowired
    private ICaloriesCalculatorService caloriesCalculatorService;

    @PostMapping("/plate_evaluation")
    @ResponseBody
    public CaloriesCalculatorResponseDTO calculateCalories(@RequestBody DishFoodDTO plate) {
        return caloriesCalculatorService.calculate(plate);
    }

}
