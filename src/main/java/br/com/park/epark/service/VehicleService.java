package br.com.park.epark.service;

import br.com.park.epark.controller.request.VehicleRequest;
import br.com.park.epark.model.Vehicle;

public interface VehicleService {

    Vehicle create(VehicleRequest request);
    Vehicle findByPlate(String plate);
}
