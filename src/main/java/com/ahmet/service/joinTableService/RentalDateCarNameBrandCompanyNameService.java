package com.ahmet.service.joinTableService;

import com.ahmet.repository.entity.joinTableEntity.RentalDateCarNameBrandCompanyName;
import com.ahmet.repository.joinTableRepository.IRentalDateCarNameBrandCompanyNameRespository;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalDateCarNameBrandCompanyNameService extends ServiceManager<RentalDateCarNameBrandCompanyName,Long> {

    private final IRentalDateCarNameBrandCompanyNameRespository rentalDateCarNameBrandCompanyNameRespository;
    public RentalDateCarNameBrandCompanyNameService(IRentalDateCarNameBrandCompanyNameRespository rentalDateCarNameBrandCompanyNameRespository){
        super(rentalDateCarNameBrandCompanyNameRespository);
        this.rentalDateCarNameBrandCompanyNameRespository=rentalDateCarNameBrandCompanyNameRespository;
    }

    public List<RentalDateCarNameBrandCompanyName> rentalDateCarNameBrandCompanyName(){
        return  rentalDateCarNameBrandCompanyNameRespository.rentalDateCarNameBrandCompanyName();
    }
}
