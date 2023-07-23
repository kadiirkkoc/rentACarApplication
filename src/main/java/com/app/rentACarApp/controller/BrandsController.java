package com.app.rentACarApp.controller;


import com.app.rentACarApp.business.abstracts.BrandService;
import com.app.rentACarApp.dtos.responses.GetBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @GetMapping("/getAll")
    public List<GetBrandsResponse> getAll(){
       return brandService.getAll();
    }

}
