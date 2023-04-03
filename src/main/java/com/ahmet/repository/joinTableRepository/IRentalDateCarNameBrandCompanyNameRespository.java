package com.ahmet.repository.joinTableRepository;

import com.ahmet.repository.entity.Car;
import com.ahmet.repository.entity.joinTableEntity.RentalDateCarNameBrandCompanyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRentalDateCarNameBrandCompanyNameRespository extends JpaRepository<RentalDateCarNameBrandCompanyName,Long> {
    @Query(value = "Select ca.car_id,cu.company_name,b.brand_name,ca.car_name,re.rent_date from cars as ca\n" +
            "INNER JOIN rental_car as r_c ON r_c.car_id=ca.car_id\n" +
            "INNER JOIN rentals  as re ON re.rental_id=r_c.rental_id\n" +
            "INNER JOIN customer_car as c_c ON c_c.car_id=ca.car_id\n" +
            "INNER JOIN customers as cu ON cu.customer_id=c_c.customer_id\n" +
            "INNER JOIN brands as b ON b.brand_id=ca.brand_id",nativeQuery = true)
    List<RentalDateCarNameBrandCompanyName> rentalDateCarNameBrandCompanyName();
}
