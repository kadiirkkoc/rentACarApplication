package com.app.rentACarApp.dataAccess;

import com.app.rentACarApp.entities.Car;
import com.app.rentACarApp.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository <Car,Long> {

    List<Model> findAllByModelId(Long id);
}
