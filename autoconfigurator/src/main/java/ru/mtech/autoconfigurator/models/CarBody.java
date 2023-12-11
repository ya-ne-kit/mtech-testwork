package ru.mtech.autoconfigurator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bodies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body_type")
    private String bodyType;

    @Column
    private Integer length;

    @Column(name = "max_width")
    private Integer maxWidth;

    @Column(name = "max_heigth")
    private Integer maxHeigth;

    private Integer quantity;
}
