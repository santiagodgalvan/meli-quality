package com.bootcamp.CaloriesCalculator.dao;
import com.bootcamp.CaloriesCalculator.model.dto.IngredientInfoDTO;
import com.bootcamp.CaloriesCalculator.repository.IFoodRepository;
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
