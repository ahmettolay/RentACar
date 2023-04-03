package com.ahmet.controller;

import com.ahmet.dto.request.SaveBrandRequestDto;
import com.ahmet.repository.entity.Brand;
import com.ahmet.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.ahmet.constants.EndPointList.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(BRAND)
public class BrandController {
    private final BrandService brandService;

    @PostMapping(SAVE)
    public ResponseEntity<Brand> save(@RequestBody @Valid SaveBrandRequestDto dto) {
        return ResponseEntity.ok(brandService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Brand>> findAll() {
        return ResponseEntity.ok(brandService.findAll());
    }
}
