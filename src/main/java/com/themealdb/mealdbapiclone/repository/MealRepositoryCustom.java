package com.themealdb.mealdbapiclone.repository;

import com.themealdb.mealdbapiclone.model.Ingredient;
import com.themealdb.mealdbapiclone.model.Meal;

import java.util.List;

public interface MealRepositoryCustom {
    List<Meal> getMealsByIngredients(List<Ingredient> ingredients);
}
