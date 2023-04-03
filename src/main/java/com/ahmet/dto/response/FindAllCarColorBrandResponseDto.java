package com.ahmet.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindAllCarColorBrandResponseDto {
    String carName;
    String brandName;
    String colorName;

}
