package com.ahmet.repository;

import com.ahmet.repository.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IColorRepository extends JpaRepository<Color,Long> {
   Optional<Color> findOptionalByColorNameIgnoreCase(String colorName);
}
