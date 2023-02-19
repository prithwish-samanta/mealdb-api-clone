package com.themealdb.mealdbapiclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "TB_MEAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    private Long idMeal;
    private String strMeal;
    private String strDrinkAlternate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "str_category_id")
    private Category strCategory;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "str_area_id")
    private Area strArea;
    @Column(length = 5000)
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
    private String strYoutube;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_meal_ingredient",
            joinColumns = @JoinColumn(name = "id_meal"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient")
    )
    private List<Ingredient> strIngredients;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strMeasure16;
    private String strMeasure17;
    private String strMeasure18;
    private String strMeasure19;
    private String strMeasure20;
    private String strSource;
    private String strImageSource;
    private Instant dateModified;

}
