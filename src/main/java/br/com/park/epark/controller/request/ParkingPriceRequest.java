package br.com.park.epark.controller.request;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ParkingPriceRequest {

    @NotNull
    private Double feeHour;
    @NotNull
    private Double feeNextHour;
    private String description;

}
