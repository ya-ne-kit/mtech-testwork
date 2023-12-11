package ru.mtech.autoconfigurator.mappers;

import ru.mtech.autoconfigurator.dto.CarBodyDto;
import ru.mtech.autoconfigurator.dto.CarBodyDtoRet;
import ru.mtech.autoconfigurator.models.CarBody;

public class CarBodyMapper {
    public static CarBodyDto toCarBodyDto(CarBody model) {
        return CarBodyDto.builder().id(model.getId())
                .bodyType(model.getBodyType())
                .maxHeigth(model.getMaxHeigth())
                .maxWidth(model.getMaxWidth())
                .quantity(model.getQuantity())
                .length(model.getLength()).build();
    }

    public static CarBodyDtoRet toCarBodyDtoRet(CarBody model) {
        return CarBodyDtoRet.builder().id(model.getId())
                .bodyType(model.getBodyType())
                .maxHeigth(model.getMaxHeigth())
                .maxWidth(model.getMaxWidth())
                .length(model.getLength()).build();
    }
}
