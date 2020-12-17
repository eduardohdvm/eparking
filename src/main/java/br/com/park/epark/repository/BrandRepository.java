package br.com.park.epark.repository;

import br.com.park.epark.model.Brand;
import br.com.park.epark.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByBrand(String brand);
    Brand findByBrandAndModel(String brand, String model);

    @Override
    default List<Brand> findAll() {
        Scanner vehicleRepository = null;
        return (List<Brand>) vehicleRepository.findAll(String.valueOf(vehicleRepository));
    }
}
