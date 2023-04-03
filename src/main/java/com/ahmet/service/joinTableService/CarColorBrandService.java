package com.ahmet.service.joinTableService;

import com.ahmet.repository.entity.joinTableEntity.JoinCarColorBrand;
import com.ahmet.repository.joinTableRepository.ICarColorBrandRepository;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarColorBrandService extends ServiceManager<JoinCarColorBrand,Long> {
    private  final ICarColorBrandRepository carColorBrandRepository;
    public  CarColorBrandService(ICarColorBrandRepository carColorBrandRepository){
        super(carColorBrandRepository);
        this.carColorBrandRepository=carColorBrandRepository;
    }
    public List<JoinCarColorBrand> findCarColorBrand(){
        return carColorBrandRepository.findCarColorBrand();
    }
}
