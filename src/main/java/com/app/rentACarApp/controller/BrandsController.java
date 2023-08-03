package com.app.rentACarApp.controller;


import com.app.rentACarApp.business.abstracts.BrandService;
import com.app.rentACarApp.dtos.requests.CreateBrandRequest;
import com.app.rentACarApp.dtos.requests.UpdateBrandRequest;
import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import com.app.rentACarApp.dtos.responses.ResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @GetMapping("/getall")
    public List<GetBrandsResponse> getAll(){
       return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandsResponse getById(@PathVariable Long id){
        return brandService.getById(id);
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseDTO add(@RequestBody CreateBrandRequest createBrandRequest){
        return brandService.add(createBrandRequest);
    }


    @PutMapping("/update")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id){
        this.brandService.delete(id);
    }

}
