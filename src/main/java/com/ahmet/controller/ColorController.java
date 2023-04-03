package com.ahmet.controller;

import com.ahmet.dto.request.SaveColorRequestDto;
import com.ahmet.repository.entity.Color;
import com.ahmet.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.ahmet.constants.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(COLOR)
public class ColorController {
    private final ColorService colorService;

    @PostMapping(SAVE)
    public ResponseEntity<Color> save(@RequestBody @Valid  SaveColorRequestDto dto) {
        return ResponseEntity.ok(colorService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Color>> findAll() {
        return ResponseEntity.ok(colorService.findAll());
    }
}
