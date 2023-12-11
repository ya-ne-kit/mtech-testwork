package ru.mtech.autoconfigurator.mappers;

import ru.mtech.autoconfigurator.dto.CarWheelDto;
import ru.mtech.autoconfigurator.dto.CarWheelDtoRet;
import ru.mtech.autoconfigurator.models.CarWheel;

public class CarWheelMapper {
    public static CarWheelDto toCarWheelDto(CarWheel model) {
        return CarWheelDto.builder().id(model.getId())
                .rimDiameter(model.getRimDiameter())
                .sideHeigth(model.getSideHeigth())
                .tireWidth(model.getTireWidth())
                .quantity(model.getQuantity())
                .build();
    }

    public static CarWheelDtoRet toCarWheelDtoRet(CarWheel model) {
        return CarWheelDtoRet.builder().id(model.getId())
                .rimDiameter(model.getRimDiameter())
                .sideHeigth(model.getSideHeigth())
                .tireWidth(model.getTireWidth())
                .build();
    }
}
