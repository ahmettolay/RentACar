package com.ahmet.service;

import com.ahmet.dto.request.SaveCarRequestDto;
import com.ahmet.exception.ErrorType;
import com.ahmet.exception.RentACcarException;
import com.ahmet.mapper.ICarMapper;
import com.ahmet.repository.ICarRepository;
import com.ahmet.repository.entity.Car;
import com.ahmet.repository.entity.joinTableEntity.CarDailyPrice;
import com.ahmet.repository.entity.joinTableEntity.JoinCarColorBrand;
import com.ahmet.repository.entity.joinTableEntity.RentalDateCarNameBrandCompanyName;
import com.ahmet.service.joinTableService.CarColorBrandService;
import com.ahmet.service.joinTableService.CarDailyPriceService;
import com.ahmet.service.joinTableService.RentalDateCarNameBrandCompanyNameService;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends ServiceManager<Car, Long> {
    private final ICarRepository carRepository;
    private final CustomerCarService customerCarService;
    private final RentalCarService rentalCarService;
    private final CarColorBrandService carColorBrandService;
    private final CarDailyPriceService carDailyPriceService;
    private final RentalDateCarNameBrandCompanyNameService rentalDateCarNameBrandCompanyNameService;

    public CarService(ICarRepository carRepository, CustomerCarService customerCarService,
                      RentalCarService rentalCarService, CarColorBrandService carColorBrandService
            , CarDailyPriceService carDailyPriceService
            , RentalDateCarNameBrandCompanyNameService rentalDateCarNameBrandCompanyNameService) {
        super(carRepository);
        this.carRepository = carRepository;
        this.customerCarService = customerCarService;
        this.rentalCarService = rentalCarService;
        this.carColorBrandService = carColorBrandService;
        this.carDailyPriceService = carDailyPriceService;
        this.rentalDateCarNameBrandCompanyNameService = rentalDateCarNameBrandCompanyNameService;

    }

    public Car save(SaveCarRequestDto dto) {
        Car car = save(ICarMapper.INSTANCE.toCar(dto));
        dto.getCustomerIds().forEach(customerId -> {
            customerCarService.save(customerId, car.getId());
        });

        dto.getRentalIds().forEach(reltaId -> {
            rentalCarService.save(reltaId, car.getId());
        });
        return car;
    }

    /**
     * Large Objects may not be used in auto-commit mode
     *
     * @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
     */

    public List<Car> findAllByCarNameStartingWithIgnoreCase(String carName) {
        List<Car> cars = carRepository.findAllByCarNameStartingWithIgnoreCase(carName);
        if(cars.isEmpty()){
            throw  new RentACcarException(ErrorType.CAR_NOT_FOUND);
        }
        return cars;
    }


    public List<Car> findAllByBrandId(Long brandId) {
        List<Car> findAllCarResponseDtoList = carRepository.findAllByBrandId(brandId);
        if(findAllCarResponseDtoList.isEmpty()){
            throw new  RentACcarException(ErrorType.CAR_NOT_FOUND);
        }
        return findAllCarResponseDtoList;
    }

    public List<Car> findAllByCarWithColorId(Long colorId) {
        List<Car> cars=carRepository.findAllByCarWithColorId(colorId);
        if (cars.isEmpty()){
            throw new  RentACcarException(ErrorType.BAD_REQUEST);
        }
        return cars;

    }

    public List<JoinCarColorBrand> findCarColorBrand() {
        List<JoinCarColorBrand> joinCarColorBrandList = carColorBrandService.findCarColorBrand();
        if (joinCarColorBrandList.isEmpty()) {
            throw new RentACcarException(ErrorType.CAR_NOT_FOUND);
        }
        return carColorBrandService.findCarColorBrand();
    }


    public List<Car> findAllByDailyPriceLessThanEqual(double dailyPrice) {
        List<Car> cars=carRepository.findAllByDailyPriceLessThanEqual(dailyPrice);
        if(cars.isEmpty()){
            throw  new RentACcarException(ErrorType.CAR_NOT_FOUND);
        }
        return cars;
    }


    public List<CarDailyPrice> findCarAndDailyPrice() {
        List<CarDailyPrice> carDailyPriceList = carDailyPriceService.findCarAndDailyPrice();
        if (carDailyPriceList.isEmpty()) {
            throw new RentACcarException(ErrorType.CAR_NOT_FOUND);
        } else {
            return carDailyPriceService.findCarAndDailyPrice();
        }

    }

    public List<RentalDateCarNameBrandCompanyName> rentalDateCarNameBrandCompanyName() {
        List<RentalDateCarNameBrandCompanyName> list=rentalDateCarNameBrandCompanyNameService.rentalDateCarNameBrandCompanyName();
        if(list.isEmpty()){
            throw  new RentACcarException(ErrorType.CAR_NOT_FOUND);
        }
        return list;

    }



}
