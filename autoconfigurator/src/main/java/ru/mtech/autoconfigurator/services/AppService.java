package ru.mtech.autoconfigurator.services;

import ru.mtech.autoconfigurator.dto.CarBodyDto;
import ru.mtech.autoconfigurator.dto.CarDto;
import ru.mtech.autoconfigurator.dto.CarWheelDto;
import ru.mtech.autoconfigurator.dto.NewCarDto;

import java.util.List;

public interface AppService {
    List<CarBodyDto> getAllCarBody();

    List<CarWheelDto> getAllCarWheels();

    CarDto createCar(NewCarDto dto);

    CarDto getCarById(Long id);

    List<CarDto> getAllCars(int from, int size);
}
