package com.ahmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveColorRequestDto {
    @NotBlank(message = "Renk  Adı boş gemezsiniz")
    @Size(min = 3, max = 50)
    String colorName;
}
