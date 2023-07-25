package com.app.rentACarApp.business.abstracts;

import com.app.rentACarApp.dtos.requests.CreateBrandRequest;
import com.app.rentACarApp.dtos.requests.UpdateBrandRequest;
import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import com.app.rentACarApp.dtos.responses.ResponseDTO;

import java.util.List;
public interface BrandService {

    List<GetBrandsResponse> getAll();
    GetBrandsResponse getById(Long id);

    ResponseDTO add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(Long id);
}
