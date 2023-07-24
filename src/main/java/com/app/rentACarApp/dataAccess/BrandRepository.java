package com.app.rentACarApp.dataAccess;

import com.app.rentACarApp.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {

    boolean existByName(String name);

}
