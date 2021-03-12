package com.bootcamp.caloriescalculator.repository;

import com.bootcamp.caloriescalculator.model.dto.IngredientInfoDTO;

import java.util.List;

public interface IFoodRepository {

    List<IngredientInfoDTO> getIngredients();
}
