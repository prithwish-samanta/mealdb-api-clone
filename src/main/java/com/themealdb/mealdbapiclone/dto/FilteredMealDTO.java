package com.themealdb.mealdbapiclone.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilteredMealDTO {
    @JsonProperty("strMeal")
    private String strMeal;
    @JsonProperty("strMealThumb")
    private String strMealThumb;
    @JsonProperty("idMeal")
    private String idMeal;

}
