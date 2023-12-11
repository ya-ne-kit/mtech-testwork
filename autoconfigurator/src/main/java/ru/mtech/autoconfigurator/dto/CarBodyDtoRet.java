package ru.mtech.autoconfigurator.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class CarBodyDtoRet {
    private Long id;
    private String bodyType;
    private Integer length;
    private Integer maxWidth;
    private Integer maxHeigth;
}
