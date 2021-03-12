package com.bootcamp.caloriescalculator.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DishFoodDTO {
    private String name;
    private List<IngredientDTO> ingredients;
}
