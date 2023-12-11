package ru.mtech.autoconfigurator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wheels")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rim_diameter")
    private String rimDiameter;

    @Column(name = "tire_width")
    private Integer tireWidth;

    @Column(name = "side_heigth")
    private Integer sideHeigth;

    private Integer quantity;
}
