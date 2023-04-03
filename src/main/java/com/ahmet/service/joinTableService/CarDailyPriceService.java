package com.ahmet.service.joinTableService;

import com.ahmet.repository.entity.joinTableEntity.CarDailyPrice;
import com.ahmet.repository.joinTableRepository.ICarDailyPriceRepository;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDailyPriceService extends ServiceManager<CarDailyPrice,Long> {
    private  final ICarDailyPriceRepository carDailyPriceRepository;

    public  CarDailyPriceService(ICarDailyPriceRepository carDailyPriceRepository){
        super(carDailyPriceRepository);
        this.carDailyPriceRepository=carDailyPriceRepository;
    }

    public List<CarDailyPrice> findCarAndDailyPrice(){
        return  carDailyPriceRepository.findCarAndDailyPrice();
    }
}
