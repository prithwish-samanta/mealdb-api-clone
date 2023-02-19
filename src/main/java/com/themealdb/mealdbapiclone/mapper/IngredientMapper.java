package com.themealdb.mealdbapiclone.mapper;

import com.themealdb.mealdbapiclone.dto.IngredientDTO;
import com.themealdb.mealdbapiclone.model.Ingredient;

public class IngredientMapper {
    private IngredientMapper() {
        throw new IllegalStateException("Mapper class");
    }

    public static IngredientDTO convertToDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .idIngredient(ingredient.getIdIngredient().toString())
                .strIngredient(ingredient.getStrIngredient())
                .strDescription(ingredient.getStrDescription())
                .strType(ingredient.getStrType())
                .build();
    }
}
