package br.com.park.epark.controller.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ParkingFinishResponse {

    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private double value;

    private VehicleResponse vehicle;

    private VacancyResponse vacancy;
}
