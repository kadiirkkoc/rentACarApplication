package com.app.rentACarApp.controller;

import com.app.rentACarApp.business.abstracts.ModelService;
import com.app.rentACarApp.dtos.requests.CreateModelRequest;
import com.app.rentACarApp.dtos.requests.UpdateModelRequest;
import com.app.rentACarApp.dtos.responses.GetModelsResponse;
import com.app.rentACarApp.dtos.responses.ResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private final ModelService modelService;

    @GetMapping()
    public List<GetModelsResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetModelsResponse getById(@PathVariable Long id){
        return modelService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseDTO add(@RequestBody CreateModelRequest createModelRequest){
        return modelService.add(createModelRequest);
    }


    @PutMapping()
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        modelService.update(updateModelRequest);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        this.modelService.delete(id);
    }
}
