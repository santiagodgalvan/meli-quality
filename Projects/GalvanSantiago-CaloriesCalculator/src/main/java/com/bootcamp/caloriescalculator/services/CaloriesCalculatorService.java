package com.bootcamp.caloriescalculator.services;

import com.bootcamp.caloriescalculator.dao.IngredientInfoDAO;
import com.bootcamp.caloriescalculator.model.dto.CaloriesCalculatorResponseDTO;
import com.bootcamp.caloriescalculator.model.dto.DishFoodDTO;
import com.bootcamp.caloriescalculator.model.dto.IngredientDTO;
import com.bootcamp.caloriescalculator.model.dto.IngredientInfoDTO;
import com.bootcamp.caloriescalculator.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CaloriesCalculatorService implements ICaloriesCalculatorService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private IngredientInfoDAO ingredientDAO;
    @Autowired
    private CaloriesCalculatorResponseDTO caloriesCalculatorResponseDTO;

    @Override
    public CaloriesCalculatorResponseDTO calculate(DishFoodDTO dish) {
        caloriesCalculatorResponseDTO.setCaloriesPerIngredient(this.getCaloriesValuesFrom(dish));
        caloriesCalculatorResponseDTO.setMostCaloricIngredient(this.getMostCaloricIngredient(dish));
        caloriesCalculatorResponseDTO.setTotalCalories(this.getPlateCalories(dish));

        return caloriesCalculatorResponseDTO;
    }

    private Map<IngredientDTO, Double> getCaloriesValuesFrom(DishFoodDTO dish) {
        Map<IngredientDTO, Double> result = new HashMap<>();
        for (IngredientDTO ingredient : dish.getIngredients()) {
            IngredientInfoDTO info = ingredientDAO.getByName(ingredient.getName());
            if (info != null)
                result.put(ingredient, info.getCalories() * ingredient.getWeight());
        }
        return result;
    }

    private HashMap<IngredientDTO, Double> getMostCaloricIngredient(DishFoodDTO dish) {
        HashMap<IngredientDTO, Double> result = null;
        IngredientDTO candidate = null;
        for (IngredientDTO ing : dish.getIngredients()) {
            if (candidate != null) {
                double caloriesResult = candidate.getWeight() * ingredientDAO.getByName(candidate.getName()).getCalories();
                double caloriesCandidate = ing.getWeight() * ingredientDAO.getByName(ing.getName()).getCalories();
                if (caloriesResult < caloriesCandidate)
                    candidate = ing;
            } else
                candidate = ing;
        }
        if(candidate != null) {
            result = new HashMap<>();
            double candidateCalories = ingredientDAO.getByName(candidate.getName()).getCalories() * candidate.getWeight();
            result.put(candidate, candidateCalories);
        }

        return result;
    }

    private double getPlateCalories(DishFoodDTO dish) {
        double result = 0;
        for(IngredientDTO ing : dish.getIngredients()) {
            result += ing.getWeight() * ingredientDAO.getByName(ing.getName()).getCalories();
        }
        return result;
    }


}
