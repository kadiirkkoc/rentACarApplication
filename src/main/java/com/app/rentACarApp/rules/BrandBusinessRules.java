package com.app.rentACarApp.rules;

import com.app.rentACarApp.dataAccess.BrandRepository;
import com.app.rentACarApp.utilities.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private final BrandRepository brandRepository;

    public void checkIfBrandNameExist(String name){
        if (brandRepository.existByName(name)){
            throw new BusinessException("There is an brand with this name.");
        }
    }


}
