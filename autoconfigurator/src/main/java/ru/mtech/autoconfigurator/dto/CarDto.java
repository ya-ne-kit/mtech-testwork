package ru.mtech.autoconfigurator.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class CarDto {
    private Long id;
    private String name;
    private CarBodyDtoRet body;
    private CarWheelDtoRet wheel;
    private Integer wheelCount;
}
