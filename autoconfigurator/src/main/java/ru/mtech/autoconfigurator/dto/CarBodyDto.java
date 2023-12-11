package ru.mtech.autoconfigurator.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class CarBodyDto {
    private Long id;
    private String bodyType;
    private Integer length;
    private Integer maxWidth;
    private Integer maxHeigth;
    private Integer quantity;
}
