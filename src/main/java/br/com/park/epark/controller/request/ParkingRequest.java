package br.com.park.epark.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingRequest {

    @NotNull
    private VehicleRequest vehicle;
    @NotNull
    private VacancyRequest vacancy;


    @Data
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VehicleRequest {
        private String plate;
    }

    @Data
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VacancyRequest {
        private Integer numberVacancy;
    }

}
