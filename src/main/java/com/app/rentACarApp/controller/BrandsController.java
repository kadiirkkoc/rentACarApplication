package com.app.rentACarApp.controller;


import com.app.rentACarApp.business.abstracts.BrandService;
import com.app.rentACarApp.dtos.requests.CreateBrandRequest;
import com.app.rentACarApp.dtos.requests.UpdateBrandRequest;
import com.app.rentACarApp.dtos.responses.GetBrandByIdResponse;
import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @GetMapping()
    public List<GetBrandsResponse> getAll(){
       return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandByIdResponse getById(@PathVariable Long id){
        return brandService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        brandService.add(createBrandRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        this.brandService.delete(id);
    }

}
