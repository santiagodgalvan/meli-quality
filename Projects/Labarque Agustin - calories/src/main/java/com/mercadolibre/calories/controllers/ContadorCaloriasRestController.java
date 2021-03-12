package com.mercadolibre.calories.controllers;

import com.mercadolibre.calories.models.CaloriesDishDTO;
import com.mercadolibre.calories.models.DishDTO;
import com.mercadolibre.calories.services.ICaloriesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContadorCaloriasRestController {

    @Autowired
    private ICaloriesCalculatorService calculator;

    @PostMapping(path = "/plato")
    public CaloriesDishDTO calculateCalories(@RequestBody DishDTO dish){ return calculator.calculate(dish); }


    @PostMapping(path = "/platos")
    public List<CaloriesDishDTO> calculateCalories(@RequestBody List<DishDTO> dishes){ return calculator.calculate(dishes); }

}
