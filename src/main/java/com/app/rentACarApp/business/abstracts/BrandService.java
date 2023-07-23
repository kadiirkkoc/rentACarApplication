package com.app.rentACarApp.business.abstracts;

import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import java.util.List;
public interface BrandService {

    List<GetBrandsResponse> getAll();
}
