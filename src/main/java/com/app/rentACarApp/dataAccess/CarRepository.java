package com.app.rentACarApp.dataAccess;

import com.app.rentACarApp.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository <Car,Long> {
}
