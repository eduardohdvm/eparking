package br.com.park.epark.controller;


import br.com.park.epark.controller.request.BrandRequest;
import br.com.park.epark.model.Brand;
import br.com.park.epark.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/brand")
    private Brand saveBrand(@RequestBody @Valid BrandRequest request){
        return brandService.create(request);
    }


}
