package br.com.park.epark.controller.request;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class VehicleRequest {

    @NotNull
    private String plate;
    @NotNull
    private String color;
    @NotNull
    private BrandRequest brand;


}
