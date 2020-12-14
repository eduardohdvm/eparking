package br.com.park.epark.controller.response;

import br.com.park.epark.enuns.VacancyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacancyResponse {

    private Long id;
    private Integer numberVacancy;
    private VacancyStatus status;
    private ParkingPriceResponse parkingPrice;
}
