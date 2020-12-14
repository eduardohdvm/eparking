package br.com.park.epark.service;

import br.com.park.epark.controller.request.ParkingPriceRequest;
import br.com.park.epark.model.ParkingPrice;

import java.util.Optional;

public interface ParkingPriceService {

    ParkingPrice create(ParkingPriceRequest request);
    Optional<ParkingPrice> findById(Long id);
}
