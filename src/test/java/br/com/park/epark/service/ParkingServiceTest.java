package br.com.park.epark.service;

import br.com.park.epark.controller.request.ParkingRequest;
import br.com.park.epark.repository.ParkingRepository;
import br.com.park.epark.service.impl.ParkingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

@SpringBootTest
public class ParkingServiceTest {

    @Mock
    private ParkingRepository parkingRepository;

    @Mock
    private VehicleService vehicleService;

    @Mock
    private VacancyService vacancyService;

    @InjectMocks
    private ParkingService parkingService = new ParkingServiceImpl();

    @Test
    public void testCreateParking_whenVehicleNotFound() {
        ParkingRequest request = new ParkingRequest();
        request.setVehicle(new ParkingRequest.VehicleRequest("hgz3339"));
        request.setVacancy(new ParkingRequest.VacancyRequest(1));

        Mockito.when(vehicleService.findByPlate(Mockito.any())).thenReturn(null);

        RuntimeException result = Assertions.assertThrows(RuntimeException.class, () -> {
            parkingService.create(request);
        });

        Assertions.assertEquals("Vehicle not found", result.getMessage());
    }


}
