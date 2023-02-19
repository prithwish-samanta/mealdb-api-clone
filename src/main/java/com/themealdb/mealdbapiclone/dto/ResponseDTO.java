package com.themealdb.mealdbapiclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO<T>{
    private T meals;
}
