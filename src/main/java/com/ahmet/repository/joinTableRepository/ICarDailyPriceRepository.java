package com.ahmet.repository.joinTableRepository;

import com.ahmet.repository.entity.joinTableEntity.CarDailyPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ICarDailyPriceRepository  extends JpaRepository<CarDailyPrice,Long> {
@Query(value = "Select ca.car_id,ca.car_name,ca.daily_price from cars as ca\n" +
        "INNER JOIN rental_car as r_c ON r_c.car_id=ca.car_id\n" +
        "INNER JOIN rentals  as re ON re.rental_id=r_c.rental_id",nativeQuery = true)
    List<CarDailyPrice> findCarAndDailyPrice();


}
