package com.themealdb.mealdbapiclone.mapper;

import com.themealdb.mealdbapiclone.dto.AreaDTO;
import com.themealdb.mealdbapiclone.model.Area;


public class AreaMapper {
    private AreaMapper() {
        throw new IllegalStateException("Mapper class");
    }

    public static AreaDTO convertToDTO(Area area) {
        return AreaDTO.builder()
                .strArea(area.getStrArea())
                .build();
    }
}
