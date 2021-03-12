package com.bootcamp.CaloriesCalculator.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class FoodPlateDTO {
    private String nombre;
    private List<IngredientDTO> ingredientes;
}
