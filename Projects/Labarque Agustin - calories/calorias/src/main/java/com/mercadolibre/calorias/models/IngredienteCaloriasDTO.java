package com.mercadolibre.calorias.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredienteCaloriasDTO {
    private String nombre;
    private Double calorias = 0.0;
}
