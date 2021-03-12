package com.bootcamp.caloriescalculator.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredientDTO {
    private String name;
    private double weight;

    @Override
    public String toString() {
        return name+" ("+weight+" gr)";
    }
}
