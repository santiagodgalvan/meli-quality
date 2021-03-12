package com.bootcamp.caloriescalculator.dao;
import com.bootcamp.caloriescalculator.model.dto.IngredientInfoDTO;
import com.bootcamp.caloriescalculator.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class IngredientInfoDAO implements DAO<IngredientInfoDTO> {
    @Autowired
    private IFoodRepository foodReposotory;

    @Override
    public IngredientInfoDTO getByName(String name) {
        IngredientInfoDTO result = null;
            Optional<IngredientInfoDTO> item = foodReposotory.getIngredients().stream()
                    .filter(ing -> ing.getName().equals(name))
                    .findFirst();

        if(item.isPresent())
            result = item.get();

        return result;
    }
}
