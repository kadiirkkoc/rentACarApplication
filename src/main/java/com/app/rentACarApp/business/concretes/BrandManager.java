package com.app.rentACarApp.business.concretes;

import com.app.rentACarApp.business.abstracts.BrandService;
import com.app.rentACarApp.dataAccess.BrandRepository;
import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import com.app.rentACarApp.entities.Brand;
import com.app.rentACarApp.utilities.mappers.ModelMapperManager;
import com.app.rentACarApp.utilities.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GetBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }
}
