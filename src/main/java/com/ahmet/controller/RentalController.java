package com.ahmet.controller;

import com.ahmet.dto.request.SaveRentalRequestDto;
import com.ahmet.repository.entity.Rental;
import com.ahmet.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ahmet.constants.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RENTAL)
public class RentalController {
    private final RentalService rentalService;

    @PostMapping(SAVE)
    public ResponseEntity<Rental> save(@RequestBody SaveRentalRequestDto dto) {
        return ResponseEntity.ok(rentalService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Rental>> findAll() {
        return ResponseEntity.ok(rentalService.findAll());
    }
}
