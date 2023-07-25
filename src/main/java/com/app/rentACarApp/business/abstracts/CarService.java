package com.app.rentACarApp.business.abstracts;

import com.app.rentACarApp.dtos.requests.CreateCarRequest;
import com.app.rentACarApp.dtos.requests.UpdateCarRequest;
import com.app.rentACarApp.dtos.responses.GetCarsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {
    List<GetCarsResponse> getAll();
    GetCarsResponse getById(Long id);

    void add(CreateCarRequest createCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    void delete(Long id);
}
