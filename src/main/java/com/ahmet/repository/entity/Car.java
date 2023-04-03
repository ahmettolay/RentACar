package com.ahmet.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    Long id;
    @Column(length = 50)
    String carName;
    @Column(name = "model_year",length = 50)
    String modelYear;
    Double dailyPrice;
    String description;
    @Column(name = "brand_id")
    Long brandId;
    @Column(name = "color_id")
    Long colorId;

}
