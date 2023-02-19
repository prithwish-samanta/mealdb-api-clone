package com.themealdb.mealdbapiclone.repository;

import com.themealdb.mealdbapiclone.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByStrIngredientIgnoreCase(String ingredient);
}
