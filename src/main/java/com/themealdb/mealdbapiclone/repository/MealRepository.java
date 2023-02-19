package com.themealdb.mealdbapiclone.repository;

import com.themealdb.mealdbapiclone.model.Area;
import com.themealdb.mealdbapiclone.model.Category;
import com.themealdb.mealdbapiclone.model.Meal;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>, MealRepositoryCustom {
    List<Meal> findByStrMealContainingIgnoreCase(String mealName, Sort sort);

    List<Meal> findByStrMealStartsWithIgnoreCase(String firstLetter, Sort sort);

    @Query(value = "SELECT * FROM TB_MEAL ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Meal randomMeal();

    @Query(value = "SELECT * FROM TB_MEAL ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Meal> getRandomSelectionMeals();

    List<Meal> findTop5ByOrderByIdMealDesc();

    List<Meal> findByStrCategory(Category category, Sort sort);

    List<Meal> findByStrArea(Area area, Sort sort);
}
