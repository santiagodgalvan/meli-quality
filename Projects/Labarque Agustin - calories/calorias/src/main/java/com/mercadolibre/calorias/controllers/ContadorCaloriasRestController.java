package com.mercadolibre.calorias.controllers;

import com.mercadolibre.calorias.models.PlatoCaloriasDTO;
import com.mercadolibre.calorias.models.PlatoDTO;
import com.mercadolibre.calorias.services.IContadorCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContadorCaloriasRestController {

    @Autowired
    private IContadorCaloriasService contador;

    @PostMapping(path = "/plato")
    public PlatoCaloriasDTO calculateCalories(@RequestBody PlatoDTO plato){ return contador.calculate(plato); }

}
