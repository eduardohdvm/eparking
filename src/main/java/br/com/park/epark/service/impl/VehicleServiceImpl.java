package br.com.park.epark.service.impl;

import br.com.park.epark.controller.request.VehicleRequest;
import br.com.park.epark.model.Brand;
import br.com.park.epark.model.Vehicle;
import br.com.park.epark.repository.BrandRepository;
import br.com.park.epark.repository.VehicleRepository;
import br.com.park.epark.service.BrandService;
import br.com.park.epark.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BrandService brandService;

    @Override
    public Vehicle create(VehicleRequest request) {
        Vehicle vehicle = vehicleRepository.findByPlate(request.getPlate());
        if (vehicle == null) {
            vehicle = new Vehicle();
            vehicle.setPlate(request.getPlate());
            vehicle.setColor(request.getColor());
            vehicle.setCreatedAt(LocalDateTime.now());
            Brand brand = brandService.create(request.getBrand());
            vehicle.setBrand(brand);
            return vehicleRepository.save(vehicle);
        }
        return vehicle;
    }

    @Override
    public Vehicle findByPlate(String plate) {
        return vehicleRepository.findByPlate(plate);
    }
}

