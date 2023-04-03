package com.ahmet.repository;

import com.ahmet.repository.entity.Color;
import com.ahmet.repository.entity.CustomerCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface ICustomerCarRepository extends JpaRepository<CustomerCar,Long> {
}
