package com.themealdb.mealdbapiclone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_AREA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    @Id
    private Long idArea;
    private String strArea;
}
