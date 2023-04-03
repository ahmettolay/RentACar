package com.ahmet.service;

import com.ahmet.dto.request.SaveCustomerRequestDto;
import com.ahmet.exception.ErrorType;
import com.ahmet.exception.RentACcarException;
import com.ahmet.mapper.IColorMapper;
import com.ahmet.mapper.ICustomerMapper;
import com.ahmet.repository.ICustomerRepository;
import com.ahmet.repository.entity.Customer;
import com.ahmet.utility.ServiceManager;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public Customer save(SaveCustomerRequestDto dto) {
        Optional<Customer> customer = customerRepository.findOptionalByCompanyNameIgnoreCase(dto.getCompanyName());
        if (customer.isPresent()) {
            throw new RentACcarException(ErrorType.COMPANY_EXIST);
        } else {
            return save(ICustomerMapper.INSTANCE.toCustomer(dto));
        }
    }
}
