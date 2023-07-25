package com.app.rentACarApp.business.abstracts;

import com.app.rentACarApp.dtos.requests.*;
import com.app.rentACarApp.dtos.responses.GetModelsResponse;

import java.util.List;

public interface ModelService {

    List<GetModelsResponse> getAll();
    GetModelsResponse getById(Long id);

    void add(CreateModelRequest createModelRequest);

    void update(UpdateModelRequest updateModelRequest);

    void delete(Long id);
}
