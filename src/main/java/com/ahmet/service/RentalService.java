package com.ahmet.service;

import com.ahmet.dto.request.SaveRentalRequestDto;
import com.ahmet.mapper.IRentalMapper;
import com.ahmet.repository.IRentalRepository;
import com.ahmet.repository.entity.Rental;
import com.ahmet.utility.ServiceManager;

import org.springframework.stereotype.Service;

@Service
public class RentalService extends ServiceManager<Rental,Long> {
    private  final IRentalRepository rentalRepository;
    public RentalService(IRentalRepository rentalRepository){
       super(rentalRepository);
        this.rentalRepository=rentalRepository;
    }
    public  Rental save(SaveRentalRequestDto dto){
      return save(IRentalMapper.INSTANCE.toRental(dto));
    }
}
