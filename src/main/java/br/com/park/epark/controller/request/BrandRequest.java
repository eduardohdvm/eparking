package br.com.park.epark.controller.request;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class BrandRequest {

    @NotNull
    private String model;
    @NotNull
    private String brand;

}
