package com.bootcamp.CaloriesCalculator.repository;

import com.bootcamp.CaloriesCalculator.model.dto.IngredientInfoDTO;

import java.util.List;

public interface IFoodRepository {

    List<IngredientInfoDTO> getIngredients();
}
