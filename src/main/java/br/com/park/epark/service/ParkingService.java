package br.com.park.epark.service;


import br.com.park.epark.controller.request.ParkingRequest;
import br.com.park.epark.model.Parking;

public interface ParkingService {

    Parking create(ParkingRequest request);

    Parking finishParking(String plate);
}
