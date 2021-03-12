package com.mercadolibre.calories.repositories;

import com.mercadolibre.calories.models.Ingredient;

public interface ICaloriesCalculatorRepository {
    Ingredient findByMealName(String name);
}
