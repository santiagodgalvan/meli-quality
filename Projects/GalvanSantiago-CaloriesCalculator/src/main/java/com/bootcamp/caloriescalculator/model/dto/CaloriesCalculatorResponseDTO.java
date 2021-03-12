package com.bootcamp.caloriescalculator.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Map;

@Getter @Setter @Service
public class CaloriesCalculatorResponseDTO {
    private double totalCalories;
    private Map<IngredientDTO, Double> caloriesPerIngredient;
    private Map<IngredientDTO, Double> mostCaloricIngredient;
}
