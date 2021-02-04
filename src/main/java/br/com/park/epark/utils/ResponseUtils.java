package br.com.park.epark.utils;


import br.com.park.epark.controller.response.*;
import br.com.park.epark.model.*;

import java.time.LocalDateTime;

public class ResponseUtils {

    public static VehicleResponse toResponse(Vehicle vehicle){
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setId(vehicle.getId());
        vehicleResponse.setPlate(vehicle.getPlate());
        vehicleResponse.setColor(vehicle.getColor());
        vehicleResponse.setBrand(toResponse(vehicle.getBrand()));
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
        vacancyResponse.setParkingPrice(toResponse(vacancy.getParkingPrice()));
        return vacancyResponse;
    }
    public static BrandResponse toResponse(Brand brand){
        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setId(brand.getId());
        brandResponse.setModel(brand.getModel());
        brandResponse.setBrand(brand.getBrand());
        return brandResponse;
    }
    public static ParkingPriceResponse toResponse(ParkingPrice parkingPrice){
        ParkingPriceResponse parkingPriceResponse = new ParkingPriceResponse();
        parkingPriceResponse.setId(parkingPrice.getId());
        parkingPriceResponse.setFeeHour(parkingPrice.getFeeHour());
        parkingPriceResponse.setFeeNextHour(parkingPrice.getFeeNextHour());
        parkingPriceResponse.setDescription(parkingPrice.getDescription());

        return parkingPriceResponse;
    }

    public static ParkingFinishResponse finish(Parking parking){
        ParkingFinishResponse parkingFinishResponse = new ParkingFinishResponse();
        parkingFinishResponse.setId(parking.getId());
        parkingFinishResponse.setStartDate(parking.getStartDate());
        parkingFinishResponse.setEndDate(parking.getEndDate());
        parkingFinishResponse.setValue(parking.getValue());
        parkingFinishResponse.setVehicle(toResponse(parking.getVehicle()));
        parkingFinishResponse.setVacancy(toResponse(parking.getVacancy()));

        return parkingFinishResponse;
    }
}
