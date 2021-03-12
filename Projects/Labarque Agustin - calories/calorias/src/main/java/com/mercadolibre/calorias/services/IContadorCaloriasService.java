package com.mercadolibre.calorias.services;

import com.mercadolibre.calorias.models.PlatoCaloriasDTO;
import com.mercadolibre.calorias.models.PlatoDTO;

import java.util.List;

public interface IContadorCaloriasService {
    PlatoCaloriasDTO calculate(PlatoDTO plato);
    List<PlatoCaloriasDTO> calculate(List<PlatoDTO> plato);
}
