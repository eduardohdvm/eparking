package br.com.park.epark.controller;


import br.com.park.epark.controller.request.VehicleRequest;
import br.com.park.epark.controller.response.BrandResponse;
import br.com.park.epark.controller.response.VehicleResponse;
import br.com.park.epark.model.Vehicle;
import br.com.park.epark.service.VehicleService;
import br.com.park.epark.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    public VehicleResponse saveVehicle(@RequestBody @Valid VehicleRequest request){
        Vehicle vehicle = vehicleService.create(request);
        return ResponseUtils.toResponse(vehicle);
    }

}
