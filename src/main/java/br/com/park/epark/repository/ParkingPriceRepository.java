package br.com.park.epark.repository;

import br.com.park.epark.model.ParkingPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPriceRepository extends JpaRepository<ParkingPrice, Long> {
    ParkingPrice findByFeeHour(Double feeHour);
}
