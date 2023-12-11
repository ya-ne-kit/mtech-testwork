package ru.mtech.autoconfigurator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtech.autoconfigurator.models.CarWheel;

public interface CarWheelRepository extends JpaRepository<CarWheel, Long> {
}
