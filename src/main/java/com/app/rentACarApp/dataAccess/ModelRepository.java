package com.app.rentACarApp.dataAccess;

import com.app.rentACarApp.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
