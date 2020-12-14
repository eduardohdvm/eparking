package br.com.park.epark.service.impl;


import br.com.park.epark.controller.request.ParkingRequest;
import br.com.park.epark.enuns.VacancyStatus;
import br.com.park.epark.model.Parking;
import br.com.park.epark.model.Vacancy;
import br.com.park.epark.model.Vehicle;
import br.com.park.epark.repository.ParkingRepository;
import br.com.park.epark.service.ParkingService;
import br.com.park.epark.service.VacancyService;
import br.com.park.epark.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VacancyService vacancyService;

    @Override
    public Parking create(ParkingRequest request) {
        Vehicle vehicle = vehicleService.findByPlate(request.getVehicle().getPlate());
        if (vehicle == null){
            throw new RuntimeException("Vehicle not found");
        }
        Vacancy vacancy = vacancyService.findByNumberVacancy(request.getVacancy().getNumberVacancy());
        if (vacancy == null){
            throw new RuntimeException("Number vacancy not found");
        }
        if (vacancy.getStatus() != VacancyStatus.AVAILABLE){
            throw new RuntimeException("Vacancy occupied");
        }
        vacancy.setStatus(VacancyStatus.OCCUPIED);
        vacancyService.update(vacancy);
        Parking parking = new Parking();
        parking.setVehicle(vehicle);
        parking.setVacancy(vacancy);
        parking.setStartDate(LocalDateTime.now());
        return parkingRepository.save(parking);
    }

    @Override
    public Parking finishParking(String plate) {
        return null;
    }
}