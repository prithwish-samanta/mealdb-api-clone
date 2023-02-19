package com.themealdb.mealdbapiclone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    private Long idCategory;
    private String strCategory;
}
