package com.ahmet.service;

import com.ahmet.dto.request.SaveBrandRequestDto;
import com.ahmet.exception.ErrorType;
import com.ahmet.exception.RentACcarException;
import com.ahmet.mapper.IBrandMapper;
import com.ahmet.repository.IBrandRepository;
import com.ahmet.repository.entity.Brand;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService extends ServiceManager<Brand, Long> {
    private final IBrandRepository brandRepository;

    public BrandService(IBrandRepository brandRepository) {
        super(brandRepository);
        this.brandRepository = brandRepository;
    }

    public Brand save(SaveBrandRequestDto dto) {
        Optional<Brand> brand = brandRepository.findOptionalByBrandNameIgnoreCase(dto.getBrandName());
        if (brand.isPresent()) {
            throw new RentACcarException(ErrorType.BRAND_EXIST) ;
        }
        return save(IBrandMapper.INSTANCE.toBrand(dto));
    }
    public List<Brand> findAll(){
        List<Brand> brands =brandRepository.findAll();
        if(brands.isEmpty()){
            throw  new RentACcarException(ErrorType.BRAND_NOT_FOUND_LIST);
        }else {
            return brands;
        }
    }

}
