package ru.mtech.autoconfigurator.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.mtech.autoconfigurator.dto.CarBodyDto;
import ru.mtech.autoconfigurator.dto.CarDto;
import ru.mtech.autoconfigurator.dto.CarWheelDto;
import ru.mtech.autoconfigurator.dto.NewCarDto;
import ru.mtech.autoconfigurator.exceptions.NotFoundException;
import ru.mtech.autoconfigurator.exceptions.ValidationException;
import ru.mtech.autoconfigurator.mappers.CarBodyMapper;
import ru.mtech.autoconfigurator.mappers.CarMapper;
import ru.mtech.autoconfigurator.mappers.CarWheelMapper;
import ru.mtech.autoconfigurator.models.Car;
import ru.mtech.autoconfigurator.models.CarBody;
import ru.mtech.autoconfigurator.models.CarWheel;
import ru.mtech.autoconfigurator.repositories.CarBodyRepository;
import ru.mtech.autoconfigurator.repositories.CarRepository;
import ru.mtech.autoconfigurator.repositories.CarWheelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppServiceImpl implements AppService {

    private final CarBodyRepository carBodyRepository;
    private final CarRepository carRepository;
    private final CarWheelRepository carWheelRepository;

    @Override
    public List<CarBodyDto> getAllCarBody() {
        return carBodyRepository.findAll().stream().map(CarBodyMapper::toCarBodyDto).toList();
    }

    @Override
    public List<CarWheelDto> getAllCarWheels() {
        return carWheelRepository.findAll().stream().map(CarWheelMapper::toCarWheelDto).toList();
    }

    @Override
    public CarDto createCar(NewCarDto dto) {
        if (dto.getWheelCount() < 2) {
            log.warn("Bad request to creating automobile with wheels less then 2");
            throw new ValidationException("Bad request to creating automobile with wheels less then 2");
        }
        CarWheel wheel = carWheelRepository.findById(dto.getWheelId()).or(() -> {
            log.warn("Bad request to creating automobile with not exists wheel id = {}", dto.getWheelId());
            throw new NotFoundException("Bad request to creating automobile with not exists wheel");
        }).get();
        CarBody body = carBodyRepository.findById(dto.getBodyId()).or(() -> {
            log.warn("Bad request to creating automobile with not exists car body id = {}", dto.getBodyId());
            throw new NotFoundException("Bad request to creating automobile with not exists car body");
        }).get();
        if (dto.getWheelCount() > wheel.getQuantity()) {
            log.warn("Bad request to creating automobile with wheels quantity less than exists");
            throw new ValidationException("Bad request to creating automobile with wheels quantity less than exists");
        }
        if (body.getQuantity() < 1) {
            log.warn("Bad request to creating automobile with car body quantity less than exists");
            throw new ValidationException("Bad request to creating automobile with car body quantity less than exists");
        }
        wheel.setQuantity(wheel.getQuantity() - dto.getWheelCount());
        body.setQuantity(body.getQuantity() - 1);
        carWheelRepository.save(wheel);
        carBodyRepository.save(body);
        return CarMapper.toCarDto(carRepository.save(Car.builder()
                .name(dto.getName())
                .wheelCount(dto.getWheelCount())
                .wheel(wheel)
                .body(body).build()));
    }

    @Override
    public CarDto getCarById(Long id) {
        return CarMapper.toCarDto(carRepository.findById(id).orElseThrow(() -> {
            log.warn("Car with ID = {} not found", id);
            return new NotFoundException("");
        }));
    }

    @Override
    public List<CarDto> getAllCars(int from, int size) {
        return carRepository.findAll(PageRequest.of(from, size)).map(CarMapper::toCarDto).toList();
    }
}
