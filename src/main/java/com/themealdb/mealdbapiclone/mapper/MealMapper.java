package com.themealdb.mealdbapiclone.mapper;

import com.themealdb.mealdbapiclone.dto.FilteredMealDTO;
import com.themealdb.mealdbapiclone.dto.MealDTO;
import com.themealdb.mealdbapiclone.model.Meal;

public class MealMapper {
    private MealMapper() {
        throw new IllegalStateException("Mapper class");
    }

    public static MealDTO convertToDTO(Meal meal) {
        return MealDTO.builder()
                .idMeal(meal.getIdMeal().toString())
                .strMeal(meal.getStrMeal())
                .strDrinkAlternate(meal.getStrDrinkAlternate())
                .strCategory(meal.getStrCategory().getStrCategory())
                .strArea(meal.getStrArea().getStrArea())
                .strInstructions(meal.getStrInstructions())
                .strMealThumb(meal.getStrMealThumb())
                .strTags(meal.getStrTags())
                .strYoutube(meal.getStrYoutube())
                .strIngredient1(getIngredientName(meal, 0))
                .strIngredient2(getIngredientName(meal, 1))
                .strIngredient3(getIngredientName(meal, 2))
                .strIngredient4(getIngredientName(meal, 3))
                .strIngredient5(getIngredientName(meal, 4))
                .strIngredient6(getIngredientName(meal, 5))
                .strIngredient7(getIngredientName(meal, 6))
                .strIngredient8(getIngredientName(meal, 7))
                .strIngredient9(getIngredientName(meal, 8))
                .strIngredient10(getIngredientName(meal, 9))
                .strIngredient11(getIngredientName(meal, 10))
                .strIngredient12(getIngredientName(meal, 11))
                .strIngredient13(getIngredientName(meal, 12))
                .strIngredient14(getIngredientName(meal, 13))
                .strIngredient15(getIngredientName(meal, 14))
                .strIngredient16(getIngredientName(meal, 15))
                .strIngredient17(getIngredientName(meal, 16))
                .strIngredient18(getIngredientName(meal, 17))
                .strIngredient19(getIngredientName(meal, 18))
                .strIngredient20(getIngredientName(meal, 19))
                .strMeasure1(meal.getStrMeasure1())
                .strMeasure2(meal.getStrMeasure2())
                .strMeasure3(meal.getStrMeasure3())
                .strMeasure4(meal.getStrMeasure4())
                .strMeasure5(meal.getStrMeasure5())
                .strMeasure6(meal.getStrMeasure6())
                .strMeasure7(meal.getStrMeasure7())
                .strMeasure8(meal.getStrMeasure8())
                .strMeasure9(meal.getStrMeasure9())
                .strMeasure10(meal.getStrMeasure10())
                .strMeasure11(meal.getStrMeasure11())
                .strMeasure12(meal.getStrMeasure12())
                .strMeasure13(meal.getStrMeasure13())
                .strMeasure14(meal.getStrMeasure14())
                .strMeasure15(meal.getStrMeasure15())
                .strMeasure16(meal.getStrMeasure16())
                .strMeasure17(meal.getStrMeasure17())
                .strMeasure18(meal.getStrMeasure18())
                .strMeasure19(meal.getStrMeasure19())
                .strMeasure20(meal.getStrMeasure20())
                .strSource(meal.getStrSource())
                .strImageSource(meal.getStrImageSource())
                .dateModified(meal.getDateModified())
                .build();
    }

    public static FilteredMealDTO convertToFilteredMealDTO(Meal meal) {
        return FilteredMealDTO.builder()
                .idMeal(meal.getIdMeal().toString())
                .strMeal(meal.getStrMeal())
                .strMealThumb(meal.getStrMealThumb())
                .build();
    }

    private static String getIngredientName(Meal meal, int index) {
        if (meal.getStrIngredients().size() > index)
            return meal.getStrIngredients().get(index).getStrIngredient();
        return null;
    }
}
