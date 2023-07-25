package com.app.rentACarApp.dtos.requests;

import com.app.rentACarApp.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {

    private Long id;
    private String name;
    private int numberOfModel;
    private List<Model> models;
}
