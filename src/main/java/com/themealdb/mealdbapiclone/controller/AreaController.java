package com.themealdb.mealdbapiclone.controller;

import com.themealdb.mealdbapiclone.dto.AreaDTO;
import com.themealdb.mealdbapiclone.dto.ResponseDTO;
import com.themealdb.mealdbapiclone.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AreaController {
    private final AreaService areaService;

    /**
     * List all areas.
     *
     * @return the response dto
     */
    @GetMapping(value = "/areas")
    public ResponseDTO<List<AreaDTO>> listAllAreas() {
        List<AreaDTO> response = areaService.listAllAreas();
        return new ResponseDTO<>(response);
    }

}
