package com.mercadolibre.calories.services;

import com.mercadolibre.calories.models.CaloriesIngredientDTO;
import com.mercadolibre.calories.models.IngredientDTO;
import com.mercadolibre.calories.models.CaloriesDishDTO;
import com.mercadolibre.calories.models.DishDTO;
import com.mercadolibre.calories.repositories.ICaloriesCalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaloriesCalculatorService implements ICaloriesCalculatorService {

    @Autowired
    private ICaloriesCalculatorRepository ingredientsRepository;

    @Override
    public List<CaloriesDishDTO> calculate(List<DishDTO> dishes){
        return dishes.stream().map(p -> calculate(p)).collect(Collectors.toList());
    }

    @Override
    public CaloriesDishDTO calculate(DishDTO dish) {

        CaloriesDishDTO caloriesDish = new CaloriesDishDTO();

        caloriesDish.setName(dish.getName());
        Double totalCalories = dish.getIngredientDTOs().stream().mapToDouble(i -> i.getWeight() * ingredientsRepository.findByMealName(i.getName()).getCalories()).sum();
        caloriesDish.setTotalCalories(totalCalories);

        List<CaloriesIngredientDTO> ingredients = new ArrayList<>();

        for(IngredientDTO ingredient: dish.getIngredientDTOs()){

            Double ingredientCalories = ingredient.getWeight() * ingredientsRepository.findByMealName(ingredient.getName()).getCalories();

            CaloriesIngredientDTO ingredientCaloriesDTO = new CaloriesIngredientDTO(); //este es el tipo de ingrediente que voy a devolver
            ingredientCaloriesDTO.setCalories(ingredientCalories);
            ingredientCaloriesDTO.setName(ingredient.getName());

            ingredients.add(ingredientCaloriesDTO);

            if(caloriesDish.getIngredient().getCalories() < ingredientCalories){
                caloriesDish.getIngredient().setCalories(ingredientCalories);
                caloriesDish.getIngredient().setName(ingredient.getName());
            }

        }


        caloriesDish.setIngredients(ingredients);

        return caloriesDish;
    }
}
