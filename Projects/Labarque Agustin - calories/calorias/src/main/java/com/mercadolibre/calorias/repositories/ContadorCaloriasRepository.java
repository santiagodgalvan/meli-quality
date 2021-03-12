package com.mercadolibre.calorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calorias.models.Ingrediente;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class ContadorCaloriasRepository implements IContadorCaloriasRepository{


    @Override
    public Ingrediente findByMealName(String name) {

        List<Ingrediente> ingredienteDAOS = null;

        ingredienteDAOS = loadDatabase();

        Ingrediente result = null;

        if(ingredienteDAOS != null){
            Optional<Ingrediente> ingrediente = ingredienteDAOS.stream().filter(i -> i.getName().equals(name)).findFirst();
            if (ingrediente.isPresent()) result = ingrediente.get();
        }

        return result;
    }

    private List<Ingrediente> loadDatabase(){

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredienteDAOS = null;

        try {
            ingredienteDAOS = objectMapper.readValue(new ClassPathResource("food.json").getFile(), typeRef);
        }catch(IOException e){
            e.printStackTrace();
        }
        return ingredienteDAOS;
    }
}
