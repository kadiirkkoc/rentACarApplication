package com.app.rentACarApp.business.concretes;

import com.app.rentACarApp.business.abstracts.BrandService;
import com.app.rentACarApp.business.abstracts.CarService;
import com.app.rentACarApp.dataAccess.BrandRepository;
import com.app.rentACarApp.dataAccess.ModelRepository;
import com.app.rentACarApp.dtos.requests.CreateBrandRequest;
import com.app.rentACarApp.dtos.requests.UpdateBrandRequest;
import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import com.app.rentACarApp.dtos.responses.ResponseDTO;
import com.app.rentACarApp.entities.Brand;
import com.app.rentACarApp.entities.Car;
import com.app.rentACarApp.entities.Model;
import com.app.rentACarApp.utilities.exceptions.BusinessException;
import com.app.rentACarApp.utilities.exceptions.ExistingNameExceptions;
import com.app.rentACarApp.utilities.mappers.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final ModelRepository modelRepository;
    private final CarService carService;
    private ResponseDTO responseDTO;

    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService, ModelRepository modelRepository, CarService carService, ResponseDTO responseDTO) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.modelRepository = modelRepository;
        this.carService = carService;
        this.responseDTO = responseDTO;
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
            throw new BusinessException("There is no brand with this id : " + id);
        }
        GetBrandsResponse brandById = this.modelMapperService.forResponse().map(brand,GetBrandsResponse.class);
        return brandById;

    }

    @Override
    public ResponseDTO add(CreateBrandRequest createBrandRequest) {
        try {
            List<Brand>brands = brandRepository.findAll();
            for (Brand brand : brands){
                if (brand.getName().equals(createBrandRequest.getName())){
                    throw new ExistingNameExceptions("There is another brand with this name! " + brand.getName());
                }
            }
            Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
            brandRepository.save(brand);
            return responseDTO.success("Your request has been processed successfully.");
        } catch (Exception e) {
            // Handle any errors
            return responseDTO.error("An error occurred while processing the request.");
        }
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        List<Model> models = modelRepository.findAllByBrandId(id);
        for (Model model : models){
            List<Car> cars = model.getCars();
            cars.forEach(car -> carService.delete(car.getId()));
        }
        modelRepository.deleteAllByBrandId(id);
        brandRepository.deleteById(id);
    }
}
