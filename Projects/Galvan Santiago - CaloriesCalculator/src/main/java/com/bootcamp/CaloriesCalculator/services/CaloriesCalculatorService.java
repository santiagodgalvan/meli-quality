package com.bootcamp.CaloriesCalculator.services;

import com.bootcamp.CaloriesCalculator.dao.IngredientInfoDAO;
import com.bootcamp.CaloriesCalculator.model.dto.CaloriesCalculatorResponseDTO;
import com.bootcamp.CaloriesCalculator.model.dto.FoodPlateDTO;
import com.bootcamp.CaloriesCalculator.model.dto.IngredientDTO;
import com.bootcamp.CaloriesCalculator.model.dto.IngredientInfoDTO;
import com.bootcamp.CaloriesCalculator.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CaloriesCalculatorService implements ICaloriesCalculatorService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private IngredientInfoDAO ingredienteDAO;
    @Autowired
    private CaloriesCalculatorResponseDTO caloriesCalculatorResponseDTO;

    @Override
    public CaloriesCalculatorResponseDTO calculate(FoodPlateDTO plate) {
        List<IngredientInfoDTO> ingredients = foodRepository.getIngredients();
        caloriesCalculatorResponseDTO.setCaloriaPorIngrediente(this.getCaloriesValuesFrom(plate));
        caloriesCalculatorResponseDTO.setIngredienteMasCalorico(this.getMostCaloricIngredient(plate));
        caloriesCalculatorResponseDTO.setCaloriasTotales(this.getPlateCalories(plate));

        return caloriesCalculatorResponseDTO;
    }

    private Map<IngredientDTO, Double> getCaloriesValuesFrom(FoodPlateDTO plate) {
        Map<IngredientDTO, Double> result = new HashMap<>();
        for (IngredientDTO ingredient : plate.getIngredientes()) {
            IngredientInfoDTO info = ingredienteDAO.getByName(ingredient.getName());
            if (info != null)
                result.put(ingredient, info.getCalories() * ingredient.getWeight());
        }
        return result;
    }

    private HashMap<IngredientDTO, Double> getMostCaloricIngredient(FoodPlateDTO plate) {
        HashMap<IngredientDTO, Double> result = null;
        IngredientDTO candidate = null;
        for (IngredientDTO ing : plate.getIngredientes()) {
            if (candidate != null) {
                double caloriesResult = candidate.getWeight() * ingredienteDAO.getByName(candidate.getName()).getCalories();
                double caloriesCandidate = ing.getWeight() * ingredienteDAO.getByName(ing.getName()).getCalories();
                if (caloriesResult < caloriesCandidate)
                    candidate = ing;
            } else
                candidate = ing;
        }
        if(candidate != null) {
            result = new HashMap<>();
            double candidateCalories = ingredienteDAO.getByName(candidate.getName()).getCalories() * candidate.getWeight();
            result.put(candidate, candidateCalories);
        }

        return result;
    }

    private double getPlateCalories(FoodPlateDTO plate) {
        double result = 0;
        for(IngredientDTO ing : plate.getIngredientes()) {
            result += ing.getWeight() * ingredienteDAO.getByName(ing.getName()).getCalories();
        }
        return result;
    }


}
