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
@Table(name = "car_color_brand")
public class JoinCarColorBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    Long id;
    @Column(name = "car_name")
    String carName;
    @Column(name = "brand_name")
    String brandName;
    @Column(name = "color_name")
    String colorName;
}
