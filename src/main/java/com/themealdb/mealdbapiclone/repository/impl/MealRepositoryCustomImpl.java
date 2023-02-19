package com.themealdb.mealdbapiclone.repository.impl;

import com.themealdb.mealdbapiclone.model.Ingredient;
import com.themealdb.mealdbapiclone.model.Meal;
import com.themealdb.mealdbapiclone.repository.MealRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class MealRepositoryCustomImpl implements MealRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Meal> getMealsByIngredients(List<Ingredient> ingredients) {
        List<Long> selectedIngredients = ingredients.stream().map(Ingredient::getIdIngredient).toList();
        final String query = "SELECT * FROM TB_MEAL WHERE ID_MEAL IN (SELECT ID_MEAL FROM TB_MEAL_INGREDIENT WHERE ID_INGREDIENT in (:selectedValues) GROUP BY ID_MEAL HAVING COUNT(DISTINCT ID_INGREDIENT)=:count) ORDER BY STR_MEAL";
        return entityManager.createNativeQuery(query, Meal.class)
                .setParameter("selectedValues", selectedIngredients)
                .setParameter("count", selectedIngredients.size())
                .getResultList();
    }
}
