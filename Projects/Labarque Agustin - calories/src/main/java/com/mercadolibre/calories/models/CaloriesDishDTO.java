package com.mercadolibre.calories.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CaloriesDishDTO {
    private String name;
    private Double totalCalories;
    private List<CaloriesIngredientDTO> ingredients;
    private CaloriesIngredientDTO ingredient;

    public CaloriesDishDTO(){
        totalCalories = 0.0;
        ingredient = new CaloriesIngredientDTO();
    }
}
