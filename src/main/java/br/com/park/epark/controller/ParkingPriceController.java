package br.com.park.epark.controller;


import br.com.park.epark.controller.request.ParkingPriceRequest;
import br.com.park.epark.controller.response.ParkingPriceResponse;
import br.com.park.epark.model.ParkingPrice;
import br.com.park.epark.service.ParkingPriceService;
import br.com.park.epark.service.impl.ParkingPriceServiceImpl;
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
public class ParkingPriceController {

    @Autowired
    private ParkingPriceService parkingPriceService;

    @PostMapping("/parking/price")
    public ParkingPriceResponse saveParkingPrice(@RequestBody @Valid ParkingPriceRequest request){
        ParkingPrice parkingPrice = parkingPriceService.create(request);
        return ResponseUtils.toResponse(parkingPrice);
    }

    @GetMapping("/parking/price")
    public List<ParkingPriceResponse> findAll(){
        List<ParkingPrice> parkingPrices = parkingPriceService.findAll();
        List<ParkingPriceResponse> responses = new ArrayList<>();
        for(ParkingPrice parkingPrice: parkingPrices){
            responses.add(ResponseUtils.toResponse(parkingPrice));
        }
        return responses;
    }

}
