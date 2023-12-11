package ru.mtech.autoconfigurator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtech.autoconfigurator.models.CarBody;

public interface CarBodyRepository extends JpaRepository<CarBody, Long> {
}
