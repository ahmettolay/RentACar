package com.ahmet.repository;

import com.ahmet.repository.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalRepository extends JpaRepository<Rental,Long> {
}
