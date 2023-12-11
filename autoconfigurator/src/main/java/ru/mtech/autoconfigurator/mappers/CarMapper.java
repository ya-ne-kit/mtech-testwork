package ru.mtech.autoconfigurator.mappers;

import ru.mtech.autoconfigurator.dto.CarDto;
import ru.mtech.autoconfigurator.models.Car;

public class CarMapper {
    public static CarDto toCarDto(Car model) {
        return CarDto.builder()
                .id(model.getId())
                .name(model.getName())
                .wheel(CarWheelMapper.toCarWheelDtoRet(model.getWheel()))
                .body(CarBodyMapper.toCarBodyDtoRet(model.getBody()))
                .wheelCount(model.getWheelCount())
                .build();
    }
}
