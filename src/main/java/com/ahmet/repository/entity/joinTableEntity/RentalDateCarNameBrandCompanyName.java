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
@Table(name = "renal_date_car_name_brand_company_name")
public class RentalDateCarNameBrandCompanyName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long carId;
    String companyName;
    String brandName;
    String carName;
    String rentDate;

}
