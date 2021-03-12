package com.mercadolibre.calories.services;

import com.mercadolibre.calories.models.CaloriesDishDTO;
import com.mercadolibre.calories.models.DishDTO;

import java.util.List;

public interface ICaloriesCalculatorService {
    CaloriesDishDTO calculate(DishDTO dish);
    List<CaloriesDishDTO> calculate(List<DishDTO> dishes);
}
