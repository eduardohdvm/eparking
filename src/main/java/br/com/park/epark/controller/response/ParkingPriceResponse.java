package br.com.park.epark.controller.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingPriceResponse {

    private Long id;
    private Double feeHour;
    private Double feeNextHour;
    private String description;

}
