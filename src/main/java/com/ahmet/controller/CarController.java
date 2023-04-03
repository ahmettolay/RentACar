package com.ahmet.controller;

import com.ahmet.dto.request.SaveCarRequestDto;
import com.ahmet.dto.response.FindAllCarColorBrandResponseDto;
import com.ahmet.repository.entity.Car;
import com.ahmet.repository.entity.joinTableEntity.CarDailyPrice;
import com.ahmet.repository.entity.joinTableEntity.JoinCarColorBrand;
import com.ahmet.repository.entity.joinTableEntity.RentalDateCarNameBrandCompanyName;
import com.ahmet.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.ahmet.constants.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CAR)
public class CarController {
    private final CarService carService;

    @PostMapping(SAVE)
    public ResponseEntity<Car> save(@RequestBody @Valid SaveCarRequestDto dto) {
        return ResponseEntity.ok(carService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Car>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping(FIND_BY_CARNAME+"/{carName}")
    public ResponseEntity<List<Car>> findAllByCarNameStartingWithIgnoreCase(@PathVariable String carName) {
        return ResponseEntity.ok(carService.findAllByCarNameStartingWithIgnoreCase(carName));
    }

    @GetMapping(FIND_BY_CAR_WITH_BRAND_ID+"/{brandId}")
    public ResponseEntity<List<Car>> findAllByCarWithBrandId(@PathVariable Long brandId) {
        return ResponseEntity.ok(carService.findAllByBrandId(brandId));
    }

    @GetMapping(FIND_ALL_BY_CAR_WITH_COLOR_ID+"/{colorId}")
    public ResponseEntity<List<Car>> findAllByCarWithColorId(@PathVariable Long colorId) {
        return ResponseEntity.ok(carService.findAllByCarWithColorId(colorId));
    }

    @GetMapping(FIND_ALL_BY_DAILY_PRICE_LESS_THAN_EQUAL+"/{dailyPrice}")
    public ResponseEntity<List<Car>> findAllByDailyPriceLessThanEqual(@PathVariable double dailyPrice) {
        return ResponseEntity.ok(carService.findAllByDailyPriceLessThanEqual(dailyPrice));
    }

    @GetMapping(FIND_CAR_COLOR_BRAND)
    public ResponseEntity<List<JoinCarColorBrand>> findCarColorBrand() {
        return ResponseEntity.ok(carService.findCarColorBrand());
    }

    @GetMapping(FIND_CAR_AND_DAILY_PRICE)
    public ResponseEntity<List<CarDailyPrice>> findCarAndDailyPrice() {
        return ResponseEntity.ok(carService.findCarAndDailyPrice());
    }
    @GetMapping(RENTAL_DATE_CAR_NAME_BRAN_COMPANY_NAME)
    public ResponseEntity<List<RentalDateCarNameBrandCompanyName>> rentalDateCarNameBrandCompanyName(){
        return  ResponseEntity.ok(carService.rentalDateCarNameBrandCompanyName());
    }

}


