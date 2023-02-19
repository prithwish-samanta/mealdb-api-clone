package com.themealdb.mealdbapiclone.service;

import com.themealdb.mealdbapiclone.dto.AreaDTO;
import com.themealdb.mealdbapiclone.mapper.AreaMapper;
import com.themealdb.mealdbapiclone.model.Area;
import com.themealdb.mealdbapiclone.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AreaService {
    private final AreaRepository areaRepository;

    public List<AreaDTO> listAllAreas() {
        List<Area> areaList = areaRepository.findAll(Sort.by(Sort.Direction.ASC, "strArea"));
        return areaList.stream().map(AreaMapper::convertToDTO).toList();
    }

    public Area getArea(String area) {
        return areaRepository.findByStrAreaIgnoreCase(area).orElse(null);
    }
}
