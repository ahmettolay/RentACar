package com.ahmet.service;

import com.ahmet.repository.ICarRepository;
import com.ahmet.repository.IRentalCarRepository;
import com.ahmet.repository.entity.Car;
import com.ahmet.repository.entity.RentalCar;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public  class RentalCarService extends ServiceManager<RentalCar,Long> {
    private final IRentalCarRepository rentalCarRepository;
    public RentalCarService(IRentalCarRepository rentalCarRepository){
        super(rentalCarRepository);
        this.rentalCarRepository=rentalCarRepository;
    }

    public void save(Long reltaId, Long carid) {
             save(  RentalCar.builder()
                     .carId(carid)
                     .rentalId(reltaId)
                     .build());
    }
}