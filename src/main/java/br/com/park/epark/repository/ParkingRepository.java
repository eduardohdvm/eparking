package br.com.park.epark.repository;


import br.com.park.epark.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

    @Query(value = "select * from parking p, vehicle v where v.id = p.id_vehicle and p.end_date is null and p.value is null and v.plate = :plate", nativeQuery = true)
    Parking findByPlate(@Param("plate") String plate);

    @Override
    Parking getOne(Long id);

    @Override
    List<Parking> findAll();

}
