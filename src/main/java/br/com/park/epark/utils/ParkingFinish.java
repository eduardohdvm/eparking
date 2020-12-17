package br.com.park.epark.utils;

import br.com.park.epark.model.Parking;

public class ParkingFinish extends Throwable {
    public ParkingFinish(Parking parking){
        System.out.println("ticket finish" + parking.getEndDate());
    }
}
