package ru.mtech.autoconfigurator.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class CarWheelDtoRet {
    private Long id;
    private String rimDiameter;
    private Integer tireWidth;
    private Integer sideHeigth;
}
