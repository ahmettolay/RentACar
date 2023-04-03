package com.ahmet.repository;

import com.ahmet.repository.entity.Car;
import com.ahmet.repository.entity.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface IRentalCarRepository extends JpaRepository<RentalCar,Long> {
}