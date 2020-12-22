package br.com.park.epark.service;


import br.com.park.epark.controller.request.ParkingRequest;
import br.com.park.epark.model.Parking;

import java.util.List;

public interface ParkingService {

    Parking create(ParkingRequest request);

    Parking finishParking(String plate);

    List<Parking> findAll();

}
