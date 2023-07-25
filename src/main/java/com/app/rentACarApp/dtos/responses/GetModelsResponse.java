package com.app.rentACarApp.dtos.responses;


import com.app.rentACarApp.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelsResponse {

    private Long id;
    private String name;
    private int numberOfCar;
    private List<Car> cars;
}
