package com.themealdb.mealdbapiclone.service;

import com.themealdb.mealdbapiclone.dto.IngredientDTO;
import com.themealdb.mealdbapiclone.mapper.IngredientMapper;
import com.themealdb.mealdbapiclone.model.Ingredient;
import com.themealdb.mealdbapiclone.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public List<IngredientDTO> listAllIngredients() {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        return ingredientList.stream().map(IngredientMapper::convertToDTO).toList();
    }

    public List<Ingredient> getAllIngredientsFromQuery(List<String> ingredients) {
        return ingredients.stream()
                .map(i -> ingredientRepository.findByStrIngredientIgnoreCase(i).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }
}
