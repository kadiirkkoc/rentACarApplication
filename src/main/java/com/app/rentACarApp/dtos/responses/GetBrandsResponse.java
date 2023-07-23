package com.app.rentACarApp.dtos.responses;

import com.app.rentACarApp.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandsResponse {

    private Long id;
    private String name;
    private int numberOfModels;
    private List<Model> models;

}
