package com.mercadolibre.calorias.services;

import com.mercadolibre.calorias.models.IngredienteCaloriasDTO;
import com.mercadolibre.calorias.models.IngredienteDTO;
import com.mercadolibre.calorias.models.PlatoCaloriasDTO;
import com.mercadolibre.calorias.models.PlatoDTO;
import com.mercadolibre.calorias.repositories.IContadorCaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContadorCaloriasService implements IContadorCaloriasService{

    @Autowired
    private IContadorCaloriasRepository ingredientesRepository;

    @Override
    public List<PlatoCaloriasDTO> calculate(List<PlatoDTO> platos){
        return platos.stream().map(p -> calculate(p)).collect(Collectors.toList());
    }

    @Override
    public PlatoCaloriasDTO calculate(PlatoDTO plato) {

        PlatoCaloriasDTO caloriasPlato = new PlatoCaloriasDTO(); //creo mi valor de retorno

        caloriasPlato.setNombre(plato.getNombre());
        Double caloriasTotales = plato.getIngredientes().stream().mapToDouble(i -> i.getWeight() * ingredientesRepository.findByMealName(i.getName()).getCalories()).sum(); //obtengo calorias totales
        caloriasPlato.setCaloriasTotales(caloriasTotales);

        List<IngredienteCaloriasDTO> ingredientes = new ArrayList<>(); //creo mi lista de ingredientes que voy a devolver

        for(IngredienteDTO ingrediente: plato.getIngredientes()){

            Double caloriasIngrediente = ingrediente.getWeight() * ingredientesRepository.findByMealName(ingrediente.getName()).getCalories();

            IngredienteCaloriasDTO ingredienteCalorias = new IngredienteCaloriasDTO(); //este es el tipo de ingrediente que voy a devolver
            ingredienteCalorias.setCalorias(caloriasIngrediente);
            ingredienteCalorias.setNombre(ingrediente.getName());

            ingredientes.add(ingredienteCalorias);

            if(caloriasPlato.getIngrediente().getCalorias() < caloriasIngrediente){
                caloriasPlato.getIngrediente().setCalorias(caloriasIngrediente);
                caloriasPlato.getIngrediente().setNombre(ingrediente.getName());
            }

        }


        caloriasPlato.setIngredientes(ingredientes);

        return caloriasPlato;
    }
}
