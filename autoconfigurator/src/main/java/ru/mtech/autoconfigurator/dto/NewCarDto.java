package ru.mtech.autoconfigurator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class NewCarDto {
    private String name;
    private Long bodyId;
    private Long wheelId;
    private Integer wheelCount;
}
