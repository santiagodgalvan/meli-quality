package com.bootcamp.CaloriesCalculator.controller;

import com.bootcamp.CaloriesCalculator.model.dto.CaloriesCalculatorResponseDTO;
import com.bootcamp.CaloriesCalculator.model.dto.FoodPlateDTO;
import com.bootcamp.CaloriesCalculator.services.ICaloriesCalculatorService;
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
    public CaloriesCalculatorResponseDTO calculateCalories(@RequestBody FoodPlateDTO plate) {
        return caloriesCalculatorService.calculate(plate);
    }

}
