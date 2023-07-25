package com.app.rentACarApp.business.concretes;

import com.app.rentACarApp.business.abstracts.CarService;
import com.app.rentACarApp.dataAccess.CarRepository;
import com.app.rentACarApp.dtos.requests.CreateCarRequest;
import com.app.rentACarApp.dtos.requests.UpdateCarRequest;
import com.app.rentACarApp.dtos.responses.GetCarsResponse;
import com.app.rentACarApp.entities.Car;
import com.app.rentACarApp.utilities.mappers.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CarManager(CarRepository carRepository, ModelMapperService modelMapperService) {
        this.carRepository = carRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarsResponse> carsResponses = cars.stream().map(car -> modelMapperService.forResponse().map(cars,GetCarsResponse.class)).collect(Collectors.toList());
        return carsResponses;
    }

    @Override
    public GetCarsResponse getById(Long id) {
        Car car = carRepository.getById(id);
        GetCarsResponse carById = modelMapperService.forResponse().map(car,GetCarsResponse.class);
        return carById;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = modelMapperService.forRequest().map(createCarRequest,Car.class);
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car = modelMapperService.forRequest().map(updateCarRequest,Car.class);
        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
