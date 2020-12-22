package br.com.park.epark.controller;


import br.com.park.epark.controller.request.ParkingRequest;
import br.com.park.epark.controller.response.ParkingFinishResponse;
import br.com.park.epark.controller.response.ParkingResponse;
import br.com.park.epark.model.Parking;
import br.com.park.epark.repository.ParkingRepository;
import br.com.park.epark.service.ParkingService;
import br.com.park.epark.utils.ParkingFinish;
import br.com.park.epark.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private ParkingRepository parkingRepository;

    @PostMapping("/parking")
    private ParkingResponse saveParking(@RequestBody @Valid ParkingRequest request) {
        Parking parking = parkingService.create(request);
        return ResponseUtils.toResponse(parking);
    }

//    @PutMapping("/parking/finish/{plate}")
//    private ParkingResponse finish(@PathVariable String plate) {
//        Parking parking = parkingService.finishParking(plate);
//        return ResponseUtils.toResponse(parking);
//    }

    @PutMapping("/parking/finish/{plate}")
    public ParkingFinishResponse finishParking(@PathVariable String plate){
        Parking finishParking = parkingService.finishParking(plate);
        return ResponseUtils.finish(finishParking);

    }

    @GetMapping("/fullValue")
    public List<ParkingFinishResponse> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingFinishResponse> responses = new ArrayList<>();
        for (Parking parking: parkingList){
            responses.add(ResponseUtils.finish(parking));
        }
        return responses;
    }


}
