package com.app.rentACarApp.business.concretes;

import com.app.rentACarApp.business.abstracts.CarService;
import com.app.rentACarApp.business.abstracts.ModelService;
import com.app.rentACarApp.dataAccess.CarRepository;
import com.app.rentACarApp.dataAccess.ModelRepository;
import com.app.rentACarApp.dtos.requests.CreateModelRequest;
import com.app.rentACarApp.dtos.requests.UpdateModelRequest;
import com.app.rentACarApp.dtos.responses.GetCarsResponse;
import com.app.rentACarApp.dtos.responses.GetModelsResponse;
import com.app.rentACarApp.entities.Car;
import com.app.rentACarApp.entities.Model;
import com.app.rentACarApp.utilities.mappers.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final CarService carService;

    @Autowired
    public ModelManager(ModelRepository modelRepository, CarRepository carRepository, ModelMapperService modelMapperService,CarService carService) {
        this.modelRepository = modelRepository;
        this.carRepository = carRepository;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
    }

    @Override
    public List<GetModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetModelsResponse> modelsResponses = models.stream().map(model -> modelMapperService.forResponse().map(models,GetModelsResponse.class)).collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public GetModelsResponse getById(Long id) {
        Model model = modelRepository.getById(id);
        GetModelsResponse modelById = modelMapperService.forResponse().map(model,GetModelsResponse.class);
        return modelById;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest,Model.class);
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = modelMapperService.forRequest().map(updateModelRequest,Model.class);
        modelRepository.save(model);
    }

    @Override
    public void delete(Long id) {
//        List<Car> cars = carRepository.findAllByModelId(id);
//        for (Car car : cars){
//            carService.delete(car.getId());
//        }
//        carRepository.deleteAllByModelId(id);
//        modelRepository.deleteById(id);
    }
}
