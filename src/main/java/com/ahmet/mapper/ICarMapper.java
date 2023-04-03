package com.ahmet.mapper;

import com.ahmet.dto.request.SaveCarRequestDto;
import com.ahmet.dto.response.FindAllCarColorBrandResponseDto;
import com.ahmet.repository.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICarMapper {
    ICarMapper INSTANCE= Mappers.getMapper(ICarMapper.class);
    Car toCar(final SaveCarRequestDto dto);

}
