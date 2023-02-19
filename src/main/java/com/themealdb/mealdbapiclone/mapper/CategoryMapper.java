package com.themealdb.mealdbapiclone.mapper;

import com.themealdb.mealdbapiclone.dto.CategoryDTO;
import com.themealdb.mealdbapiclone.model.Category;

public class CategoryMapper {
    private CategoryMapper() {
        throw new IllegalStateException("Mapper class");
    }

    public static CategoryDTO convertToDTO(Category category) {
        return CategoryDTO.builder()
                .strCategory(category.getStrCategory())
                .build();
    }
}
