package br.com.park.epark.service;

import br.com.park.epark.controller.request.BrandRequest;
import br.com.park.epark.model.Brand;
import br.com.park.epark.repository.BrandRepository;
import br.com.park.epark.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandService brandService = new BrandServiceImpl();

    @Test
    public void testCreateBrandSuccess() {
        BrandRequest brandRequest = new BrandRequest();
        brandRequest.setBrand("Ford");
        brandRequest.setModel("Fiesta");

        when(brandRepository.findByBrandAndModel(any(), any())).thenReturn(null);
        when(brandRepository.save(any())).thenReturn(new Brand(1L, brandRequest.getModel(), brandRequest.getBrand()));

        Brand brand = brandService.create(brandRequest);

        assertNotNull(brand);
        assertEquals(brandRequest.getBrand(), brand.getBrand());
        assertEquals(brandRequest.getModel(), brand.getModel());
    }
}
