package br.com.park.epark.repository;

import br.com.park.epark.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByBrandAndModel(String brand, String model);
}
