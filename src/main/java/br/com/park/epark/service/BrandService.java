package br.com.park.epark.service;

import br.com.park.epark.controller.request.BrandRequest;
import br.com.park.epark.model.Brand;
import br.com.park.epark.model.Vehicle;

import java.util.List;

public interface BrandService {

    Brand create(BrandRequest request);

    List<Vehicle> findAll();
}
