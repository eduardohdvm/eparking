package br.com.park.epark.controller.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponse {

    private Long id;
    private String plate;
    private String color;
    private BrandResponse brand;

}
