package br.com.park.epark.controller.response;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ParkingResponse {

    private Long id;

    private LocalDateTime startDate;

    private VehicleResponse vehicle;

    private VacancyResponse vacancy;

}
