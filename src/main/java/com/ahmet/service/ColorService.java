package com.ahmet.service;

import com.ahmet.dto.request.SaveColorRequestDto;
import com.ahmet.exception.ErrorType;
import com.ahmet.exception.RentACcarException;
import com.ahmet.mapper.IColorMapper;
import com.ahmet.repository.IColorRepository;
import com.ahmet.repository.entity.Color;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorService extends ServiceManager<Color, Long> {
    private final IColorRepository colorRepository;

    public ColorService(IColorRepository colorRepository) {
        super(colorRepository);
        this.colorRepository = colorRepository;
    }

    public Color save(SaveColorRequestDto dto) {
        Optional<Color> color = colorRepository.findOptionalByColorNameIgnoreCase(dto.getColorName());
        if (color.isPresent()) {
            throw new RentACcarException(ErrorType.COLOR_EXIST);
        } else {
            return save(IColorMapper.INSTANCE.toColor(dto));
        }
    }
}
