package com.bootcamp.CaloriesCalculator.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Map;

@Getter @Setter @Service
public class CaloriesCalculatorResponseDTO {
    private double caloriasTotales;
    private Map<IngredientDTO, Double> caloriaPorIngrediente;
    private Map<IngredientDTO, Double> ingredienteMasCalorico;
}
