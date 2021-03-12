package com.mercadolibre.calories.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaloriesIngredientDTO {
    private String name;
    private Double calories = 0.0;
}
