package br.com.park.epark.service.impl;


import br.com.park.epark.controller.request.ParkingPriceRequest;
import br.com.park.epark.model.ParkingPrice;
import br.com.park.epark.repository.ParkingPriceRepository;
import br.com.park.epark.service.ParkingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingPriceServiceImpl implements ParkingPriceService {


    @Autowired
    private ParkingPriceRepository parkingPriceRepository;

    @Override
    public ParkingPrice create(ParkingPriceRequest request) {
        ParkingPrice parkingPrice = parkingPriceRepository.findByFeeHour(request.getFeeHour());
        if (parkingPrice == null){
            parkingPrice = new ParkingPrice();
            parkingPrice.setFeeHour(request.getFeeHour());
            parkingPrice.setFeeNextHour(request.getFeeNextHour());
            parkingPrice.setDescription(request.getDescription());
            return parkingPriceRepository.save(parkingPrice);
        }
        return parkingPrice;
    }

    @Override
    public Optional<ParkingPrice> findById(Long id) {
        return parkingPriceRepository.findById(id);
    }
}
