package br.com.park.epark.service;

import br.com.park.epark.controller.request.BrandRequest;
import br.com.park.epark.model.Brand;

public interface BrandService {

    Brand create(BrandRequest request);
}
