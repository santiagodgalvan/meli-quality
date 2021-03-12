package com.mercadolibre.calorias.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatoCaloriasDTO {
    private String nombre;
    private Double caloriasTotales;
    private List<IngredienteCaloriasDTO> ingredientes;
    private IngredienteCaloriasDTO ingrediente;

    public PlatoCaloriasDTO(){
        caloriasTotales = 0.0;
        ingrediente = new IngredienteCaloriasDTO();
    }
}
