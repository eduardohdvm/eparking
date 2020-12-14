package br.com.park.epark.controller;


import br.com.park.epark.controller.request.ParkingRequest;
import br.com.park.epark.controller.response.ParkingResponse;
import br.com.park.epark.model.Parking;
import br.com.park.epark.service.ParkingService;
import br.com.park.epark.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("/parking")
    private ParkingResponse saveParking(@RequestBody @Valid ParkingRequest request) {
        Parking parking = parkingService.create(request);
        return ResponseUtils.toResponse(parking);
    }

    @PutMapping("/parking/{plate}/finish")
    private ParkingResponse finishParking(@PathVariable String plate) {
        Parking parking = parkingService.finishParking(plate);
        return ResponseUtils.toResponse(parking);
    }


}
