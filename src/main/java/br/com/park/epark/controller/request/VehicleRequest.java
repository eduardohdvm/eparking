package br.com.park.epark.controller.request;


import br.com.park.epark.model.Brand;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


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
