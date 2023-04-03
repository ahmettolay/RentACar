package com.ahmet.repository.joinTableRepository;

import com.ahmet.repository.entity.Car;
import com.ahmet.repository.entity.joinTableEntity.JoinCarColorBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICarColorBrandRepository extends JpaRepository<JoinCarColorBrand,Long> {
    @Query(value = "Select ca.car_id,ca.car_name,co.color_name,b.brand_name from cars as ca\n" +
            "INNER JOIN colors as co ON co.color_id=ca.color_id\n" +
            "INNER JOIN brands as b ON b.brand_id=ca.brand_id", nativeQuery = true)
    List<JoinCarColorBrand> findCarColorBrand();
}
