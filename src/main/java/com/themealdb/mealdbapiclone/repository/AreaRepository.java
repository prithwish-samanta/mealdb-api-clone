package com.themealdb.mealdbapiclone.repository;

import com.themealdb.mealdbapiclone.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByStrAreaIgnoreCase(String area);
}
