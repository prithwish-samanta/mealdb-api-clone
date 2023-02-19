package com.themealdb.mealdbapiclone.service;

import com.themealdb.mealdbapiclone.dto.FilteredMealDTO;
import com.themealdb.mealdbapiclone.dto.MealDTO;
import com.themealdb.mealdbapiclone.mapper.MealMapper;
import com.themealdb.mealdbapiclone.model.Area;
import com.themealdb.mealdbapiclone.model.Category;
import com.themealdb.mealdbapiclone.model.Ingredient;
import com.themealdb.mealdbapiclone.model.Meal;
import com.themealdb.mealdbapiclone.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MealService {
    private final MealRepository mealRepository;
    private final CategoryService categoryService;
    private final AreaService areaService;
    private final IngredientService ingredientService;

    public List<MealDTO> searchMealByName(String mealName) {
        List<Meal> meals = mealRepository.findByStrMealContainingIgnoreCase(
                mealName,
                Sort.by(Sort.Direction.ASC, "idMeal")
        );
        if (!meals.isEmpty())
            return meals.stream().map(MealMapper::convertToDTO).toList();
        return null;
    }

    public List<MealDTO> listAllMealsByFirstLetter(Character firstLetter) {
        List<Meal> meals = mealRepository.findByStrMealStartsWithIgnoreCase(
                firstLetter.toString(),
                Sort.by(Sort.Direction.ASC, "idMeal")
        );
        if (!meals.isEmpty())
            return meals.stream().map(MealMapper::convertToDTO).toList();
        return null;
    }

    public List<MealDTO> lookupMeal(String mealId) {
        try {
            Optional<Meal> meal = mealRepository.findById(Long.parseLong(mealId));
            return meal.map(value -> List.of(MealMapper.convertToDTO(value))).orElse(null);
        } catch (NumberFormatException e) {
            log.error(e.toString());
            return null;
        }
    }

    public List<MealDTO> randomMeal() {
        Meal meal = mealRepository.randomMeal();
        return List.of(MealMapper.convertToDTO(meal));
    }

    public List<MealDTO> getRandomSelectionMeals() {
        List<Meal> meals = mealRepository.getRandomSelectionMeals();
        return meals.stream().map(MealMapper::convertToDTO).toList();
    }

    public List<MealDTO> getLatestMeals() {
        List<Meal> meals = mealRepository.findTop5ByOrderByIdMealDesc();
        return meals.stream().map(MealMapper::convertToDTO).toList();
    }

    public List<FilteredMealDTO> filterMealByIngredients(String ingredients) {
        List<Ingredient> queryIngredients = ingredientService
                .getAllIngredientsFromQuery(parseIngredientsFromQuery(ingredients));
        List<Meal> meals = mealRepository.getMealsByIngredients(queryIngredients);
        if (!meals.isEmpty())
            return meals.stream().map(MealMapper::convertToFilteredMealDTO).toList();
        return null;
    }

    public List<FilteredMealDTO> filterMealByCategory(String category) {
        Category fetchedCategory = categoryService.getCategory(category);
        if (fetchedCategory != null) {
            List<Meal> meals = mealRepository.findByStrCategory(
                    fetchedCategory,
                    Sort.by(Sort.Direction.ASC, "strMeal")
            );
            return meals.stream().map(MealMapper::convertToFilteredMealDTO).toList();
        }
        return null;
    }

    public List<FilteredMealDTO> filterMealByArea(String area) {
        Area fetchedArea = areaService.getArea(area);
        if (area != null) {
            List<Meal> meals = mealRepository.findByStrArea(
                    fetchedArea,
                    Sort.by(Sort.Direction.ASC, "strMeal")
            );
            return meals.stream().map(MealMapper::convertToFilteredMealDTO).toList();
        }
        return null;
    }

    private List<String> parseIngredientsFromQuery(String ingredients) {
        List<String> ing = Arrays.stream(ingredients.split(",")).toList();
        return ing.stream().map(i -> i.replace('_', ' ')).toList();
    }
}
