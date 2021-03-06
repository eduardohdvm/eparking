package br.com.park.epark.service.impl;


import br.com.park.epark.controller.request.BrandRequest;
import br.com.park.epark.controller.response.VehicleResponse;
import br.com.park.epark.model.Brand;
import br.com.park.epark.model.Vehicle;
import br.com.park.epark.repository.BrandRepository;
import br.com.park.epark.repository.VehicleRepository;
import br.com.park.epark.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Brand create(BrandRequest request) {
        Brand brand = brandRepository.findByBrandAndModel(request.getBrand(), request.getModel());
        if (brand == null) {
            brand = new Brand();
            brand.setBrand(request.getBrand());
            brand.setModel(request.getModel());
            return brandRepository.save(brand);
        }
        return brand;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }


}
