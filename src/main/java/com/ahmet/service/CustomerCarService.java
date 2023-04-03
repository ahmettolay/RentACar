package com.ahmet.service;

import com.ahmet.repository.ICarRepository;
import com.ahmet.repository.ICustomerCarRepository;
import com.ahmet.repository.entity.Color;
import com.ahmet.repository.entity.CustomerCar;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public  class CustomerCarService extends ServiceManager<CustomerCar,Long> {
    private  final ICustomerCarRepository customerCarRepository;
    public CustomerCarService(ICustomerCarRepository customerCarRepository){
        super(customerCarRepository);
        this.customerCarRepository=customerCarRepository;
    }

    public  void save(Long customerId,Long carId){
        save(CustomerCar.builder()
                .customerId(customerId)
                .carId(carId)
                .build());
    }
}
