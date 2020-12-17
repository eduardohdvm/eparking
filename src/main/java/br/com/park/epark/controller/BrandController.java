package br.com.park.epark.controller;


import br.com.park.epark.controller.request.BrandRequest;
import br.com.park.epark.controller.response.BrandResponse;
import br.com.park.epark.controller.response.VacancyResponse;
import br.com.park.epark.controller.response.VehicleResponse;
import br.com.park.epark.model.Brand;
import br.com.park.epark.model.Vacancy;
import br.com.park.epark.model.Vehicle;
import br.com.park.epark.service.BrandService;
import br.com.park.epark.service.VehicleService;
import br.com.park.epark.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/brand")
    private BrandResponse saveBrand(@RequestBody @Valid BrandRequest request){
        Brand brand = brandService.create(request);
        return ResponseUtils.toResponse(brand);
    }
    @GetMapping("/brand")
    public List<VehicleResponse> findAll(){
        List<Vehicle> vehicles = vehicleService.findAll();
        List<VehicleResponse> response = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            response.add(ResponseUtils.toResponse(vehicle));
        }
        return response;
    }



}
