package com.app.rentACarApp.business.concretes;

import com.app.rentACarApp.business.abstracts.BrandService;
import com.app.rentACarApp.dataAccess.BrandRepository;
import com.app.rentACarApp.dataAccess.ModelRepository;
import com.app.rentACarApp.dtos.requests.CreateBrandRequest;
import com.app.rentACarApp.dtos.requests.UpdateBrandRequest;
import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import com.app.rentACarApp.entities.Brand;
import com.app.rentACarApp.entities.Model;
import com.app.rentACarApp.utilities.exceptions.BusinessException;
import com.app.rentACarApp.utilities.mappers.ModelMapperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final ModelRepository modelRepository;

    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService,ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<GetBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GetBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }
    @Override
    public GetBrandsResponse getById(Long id){
        Brand brand = brandRepository.getById(id);
        if (!brandRepository.existsBrandById(id)){
            throw new BusinessException("There is no brand with this id :" + id);
        }
        GetBrandsResponse brandById = this.modelMapperService.forResponse().map(brand,GetBrandsResponse.class);
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
        List<Model> models = modelRepository.findAll();


    }

}
