package com.bootcamp.caloriescalculator.repository;

import com.bootcamp.caloriescalculator.model.dto.IngredientInfoDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Getter @Setter @Repository
public class FoodRepository implements IFoodRepository {

    private List<IngredientInfoDTO> cache;

    @Override
    public List<IngredientInfoDTO> getIngredients() {
        if(cache == null)
            cache = loadDB();

        return cache;
    }

    public List<IngredientInfoDTO> loadDB() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientInfoDTO>> typeRef = new TypeReference<>() {};
        List<IngredientInfoDTO> ingredientDTOS = null;
        try{
            ingredientDTOS = objectMapper.readValue(file, typeRef);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientDTOS;
    }

}
