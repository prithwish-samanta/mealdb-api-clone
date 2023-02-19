package com.themealdb.mealdbapiclone.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_INGREDIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    private Long idIngredient;
    private String strIngredient;
    @Column(length = 3000)
    private String strDescription;
    private String strType;
}
