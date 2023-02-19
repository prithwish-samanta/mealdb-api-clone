package com.themealdb.mealdbapiclone.controller;

import com.themealdb.mealdbapiclone.dto.FilteredMealDTO;
import com.themealdb.mealdbapiclone.dto.MealDTO;
import com.themealdb.mealdbapiclone.dto.ResponseDTO;
import com.themealdb.mealdbapiclone.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    /**
     * Search meal by name.
     *
     * @param mealName the meal name
     * @return the response dto
     */
    @GetMapping(value = "/search", params = "s")
    public ResponseDTO<List<MealDTO>> searchMealByName(
            @RequestParam(value = "s", required = true) String mealName
    ) {
        List<MealDTO> response = mealService.searchMealByName(mealName);
        return new ResponseDTO<>(response);
    }

    /**
     * List all meals by first letter.
     *
     * @param firstLetter the first letter
     * @return the response dto
     */
    @GetMapping(value = "/search", params = "f")
    public ResponseDTO<List<MealDTO>> listAllMealsByFirstLetter(
            @RequestParam(value = "f", required = true) Character firstLetter
    ) {
        List<MealDTO> response = mealService.listAllMealsByFirstLetter(firstLetter);
        return new ResponseDTO<>(response);
    }

    /**
     * Lookup meal by id
     *
     * @param mealId the meal id
     * @return the response dto
     */
    @GetMapping(value = "/lookup", params = "i")
    public ResponseDTO<List<MealDTO>> lookupMeal(
            @RequestParam(value = "i", required = true) String mealId
    ) {
        List<MealDTO> response = mealService.lookupMeal(mealId);
        return new ResponseDTO<>(response);
    }

    /**
     * Look up a single random meal.
     *
     * @return the response dto
     */
    @GetMapping(value = "/random")
    public ResponseDTO<List<MealDTO>> randomMeal() {
        List<MealDTO> response = mealService.randomMeal();
        return new ResponseDTO<>(response);
    }

    /**
     * Lookup random selection meals.
     *
     * @return the random selection meals
     */
    @GetMapping(value = "/randomselection")
    public ResponseDTO<List<MealDTO>> getRandomSelectionMeals() {
        List<MealDTO> response = mealService.getRandomSelectionMeals();
        return new ResponseDTO<>(response);
    }

    /**
     * Gets latest meals.
     *
     * @return the latest meals
     */
    @GetMapping("/latest")
    public ResponseDTO<List<MealDTO>> getLatestMeals() {
        List<MealDTO> response = mealService.getLatestMeals();
        return new ResponseDTO<>(response);
    }

    /**
     * Filter meal by ingredients.
     *
     * @param ingredients the ingredients
     * @return the response dto
     */
    @GetMapping(value = "/filter", params = "i")
    public ResponseDTO<List<FilteredMealDTO>> filterMealByIngredients(
            @RequestParam(value = "i", required = true) String ingredients
    ) {
        List<FilteredMealDTO> response = mealService.filterMealByIngredients(ingredients);
        return new ResponseDTO<>(response);
    }

    /**
     * Filter meal by category.
     *
     * @param category the category
     * @return the response dto
     */
    @GetMapping(value = "/filter", params = "c")
    public ResponseDTO<List<FilteredMealDTO>> filterMealByCategory(
            @RequestParam(value = "c", required = true) String category
    ) {
        List<FilteredMealDTO> response = mealService.filterMealByCategory(category);
        return new ResponseDTO<>(response);
    }

    /**
     * Filter meal by area.
     *
     * @param area the area
     * @return the response dto
     */
    @GetMapping(value = "/filter", params = "a")
    public ResponseDTO<List<FilteredMealDTO>> filterMealByArea(
            @RequestParam(value = "a", required = true) String area
    ) {
        List<FilteredMealDTO> response = mealService.filterMealByArea(area);
        return new ResponseDTO<>(response);
    }

}
