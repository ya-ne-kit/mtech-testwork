package ru.mtech.autoconfigurator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "body_id")
    private CarBody body;

    @ManyToOne
    @JoinColumn(name = "wheel_id")
    private CarWheel wheel;

    @Column(name = "wheel_count")
    private Integer wheelCount;
}
