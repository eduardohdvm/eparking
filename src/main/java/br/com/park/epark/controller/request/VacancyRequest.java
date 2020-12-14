package br.com.park.epark.controller.request;

import br.com.park.epark.enuns.VacancyStatus;
import br.com.park.epark.model.ParkingPrice;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class VacancyRequest {

    @NotNull
    private Integer numberVacancy;
    @NotNull
    private Long idParkingPrice;


}
