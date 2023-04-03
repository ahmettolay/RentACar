package com.ahmet.repository;

import com.ahmet.repository.entity.Car;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByCarNameStartingWithIgnoreCase(String carName);


    @Query(value = "Select * FROM cars WHERE brand_id= ?1", nativeQuery = true)
    List<Car> findAllByBrandId(Long brandId);


    @Query(value = "select * from cars where color_id= ?1", nativeQuery = true)
    List<Car> findAllByCarWithColorId(Long colorId);

    List<Car> findAllByDailyPriceLessThanEqual(double dailyPrice);

}
