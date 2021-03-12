package com.mercadolibre.calories.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DishDTO {
    private String name;
    private List<IngredientDTO> ingredientDTOs;
}
