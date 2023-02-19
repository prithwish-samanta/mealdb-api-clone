package com.themealdb.mealdbapiclone.controller;

import com.themealdb.mealdbapiclone.dto.IngredientDTO;
import com.themealdb.mealdbapiclone.dto.ResponseDTO;
import com.themealdb.mealdbapiclone.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    /**
     * List all ingredients.
     *
     * @return the response dto
     */
    @GetMapping(value = "/ingredients")
    public ResponseDTO<List<IngredientDTO>> listAllIngredients() {
        List<IngredientDTO> response = ingredientService.listAllIngredients();
        return new ResponseDTO<>(response);
    }

}
