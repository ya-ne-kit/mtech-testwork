package ru.mtech.autoconfigurator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtech.autoconfigurator.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
