package com.ahmet.repository.entity.joinTableEntity;

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
@Table(name = "car_daily_price")
public class CarDailyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long carId;
    String carName;
    Double dailyPrice;
}
