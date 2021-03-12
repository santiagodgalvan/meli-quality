package com.mercadolibre.calories.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calories.models.Ingredient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriesCalculatorRepository implements ICaloriesCalculatorRepository {


    @Override
    public Ingredient findByMealName(String name) {

        List<Ingredient> ingredientDAOS = null;

        ingredientDAOS = loadDatabase();

        Ingredient result = null;

        if(ingredientDAOS != null){
            Optional<Ingredient> ingredient = ingredientDAOS.stream().filter(i -> i.getName().equals(name)).findFirst();
            if (ingredient.isPresent()) result = ingredient.get();
        }

        return result;
    }

    private List<Ingredient> loadDatabase(){

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredientDAOS = null;

        try {
            ingredientDAOS = objectMapper.readValue(new ClassPathResource("food.json").getFile(), typeRef);
        }catch(IOException e){
            e.printStackTrace();
        }
        return ingredientDAOS;
    }
}
