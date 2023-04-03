package com.ahmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveCarRequestDto {
    @NotBlank(message = "Marka Adı boş gemezsiniz")
    @Size(min = 3, max = 50)
    String carName;
    String modelYear;
    Double dailyPrice;
    String description;
    Long brandId;
    Long colorId;
    List<Long> customerIds;
    List<Long> rentalIds;
}
