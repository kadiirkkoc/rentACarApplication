package com.app.rentACarApp.business.concretes;

import com.app.rentACarApp.business.abstracts.BrandService;
import com.app.rentACarApp.dataAccess.BrandRepository;
import com.app.rentACarApp.dtos.requests.CreateBrandRequest;
import com.app.rentACarApp.dtos.requests.UpdateBrandRequest;
import com.app.rentACarApp.dtos.responses.GetBrandByIdResponse;
import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import com.app.rentACarApp.entities.Brand;
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

    public GetBrandByIdResponse getById(Long id){
        Brand brand = brandRepository.getById(id);
        GetBrandByIdResponse brandById = this.modelMapperService.forResponse().map(brand,GetBrandByIdResponse.class);
        return brandById;

    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }




}
