package br.com.park.epark.controller;


import br.com.park.epark.controller.request.ParkingPriceRequest;
import br.com.park.epark.model.ParkingPrice;
import br.com.park.epark.service.ParkingPriceService;
import br.com.park.epark.service.impl.ParkingPriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ParkingPriceController {

    @Autowired
    private ParkingPriceService parkingPriceService;

    @PostMapping("/parking/price")
    public ParkingPrice saveParkingPrice(@RequestBody @Valid ParkingPriceRequest request){
        return parkingPriceService.create(request);
    }




}
