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
public class IngredientDTO {
    @JsonProperty("idIngredient")
    private String idIngredient;
    @JsonProperty("strIngredient")
    private String strIngredient;
    @JsonProperty("strDescription")
    private String strDescription;
    @JsonProperty("strType")
    private String strType;
}
