package ru.mtech.autoconfigurator.controllers;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mtech.autoconfigurator.dto.CarBodyDto;
import ru.mtech.autoconfigurator.dto.CarDto;
import ru.mtech.autoconfigurator.dto.CarWheelDto;
import ru.mtech.autoconfigurator.dto.NewCarDto;
import ru.mtech.autoconfigurator.services.AppService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
@Validated
@Slf4j
public class AppController {

    private final AppService appService;

    @GetMapping("/bodies")
    public List<CarBodyDto> getAllCarBody() {
        log.info("GET all car bodies request received to endpoint [/bodies]");
        return appService.getAllCarBody();
    }

    @GetMapping("/wheels")
    public List<CarWheelDto> getAllCarWheels() {
        log.info("GET all car wheels request received to endpoint [/wheels]");
        return appService.getAllCarWheels();
    }

    @PostMapping("/create-car")
    public CarDto createCar(@RequestBody NewCarDto dto) {
        log.info("POST car request received to endpoint [/create-car]");
        return appService.createCar(dto);
    }

    @GetMapping("/car")
    public CarDto getCar(@RequestParam Long id) {
        log.info("GET car by id = {} request received to endpoint [/car]", id);
        return appService.getCarById(id);
    }

    @GetMapping("/cars")
    public List<CarDto> getAllCars(@PositiveOrZero @RequestParam(defaultValue = "0") int from,
                                       @Positive @RequestParam(defaultValue = "10") int size) {
        log.info("GET all cars request received to endpoint [/cars]");
        return appService.getAllCars(from, size);
    }
}
