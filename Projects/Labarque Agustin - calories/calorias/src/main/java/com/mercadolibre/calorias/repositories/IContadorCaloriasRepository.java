package com.mercadolibre.calorias.repositories;

import com.mercadolibre.calorias.models.Ingrediente;

public interface IContadorCaloriasRepository {
    Ingrediente findByMealName(String name);
}
