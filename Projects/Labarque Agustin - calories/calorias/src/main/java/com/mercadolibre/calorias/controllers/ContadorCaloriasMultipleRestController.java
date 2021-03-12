package com.mercadolibre.calorias.controllers;

import com.mercadolibre.calorias.models.PlatoCaloriasDTO;
import com.mercadolibre.calorias.models.PlatoDTO;
import com.mercadolibre.calorias.services.IContadorCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContadorCaloriasMultipleRestController {

    @Autowired
    private IContadorCaloriasService contador;

    @PostMapping(path = "/platos")
    public List<PlatoCaloriasDTO> calculateCalories(@RequestBody List<PlatoDTO> platos){ return contador.calculate(platos); }

}
