package br.com.park.epark.utils;


import br.com.park.epark.controller.response.*;
import br.com.park.epark.model.Parking;
import br.com.park.epark.model.Vacancy;
import br.com.park.epark.model.Vehicle;

import java.time.LocalDateTime;

public class ResponseUtils {

    public static VehicleResponse toResponse(Vehicle vehicle){
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setId(vehicle.getId());
        vehicleResponse.setPlate(vehicle.getPlate());
        vehicleResponse.setColor(vehicle.getColor());
        vehicleResponse.setBrand(
                new BrandResponse(
                        vehicle.getBrand().getId(),
                        vehicle.getBrand().getModel(),
                        vehicle.getBrand().getBrand()
                )
        );
        return vehicleResponse;
    }

    public static ParkingResponse toResponse(Parking parking) {
        ParkingResponse parkingResponse = new ParkingResponse();
        parkingResponse.setId(parking.getId());
        parkingResponse.setStartDate(LocalDateTime.now());
        parkingResponse.setVehicle(toResponse(parking.getVehicle()));
        parkingResponse.setVacancy(toResponse(parking.getVacancy()));
        return parkingResponse;
    }

    public static VacancyResponse toResponse(Vacancy vacancy) {
        VacancyResponse vacancyResponse = new VacancyResponse();
        vacancyResponse.setId(vacancy.getId());
        vacancyResponse.setNumberVacancy(vacancy.getNumberVacancy());
        vacancyResponse.setStatus(vacancy.getStatus());
        vacancyResponse.setParkingPrice(
                new ParkingPriceResponse(
                        vacancy.getParkingPrice().getId(),
                        vacancy.getParkingPrice().getFeeHour(),
                        vacancy.getParkingPrice().getFeeNextHour(),
                        vacancy.getParkingPrice().getDescription()

                )
        );
        return vacancyResponse;
    }
}
