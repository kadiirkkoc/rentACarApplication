package com.app.rentACarApp.dataAccess;

import com.app.rentACarApp.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Long> {

    List<Model> findAllByBrandId(Long id);
}
