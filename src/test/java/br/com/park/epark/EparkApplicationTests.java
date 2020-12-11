package br.com.park.epark;

import br.com.park.epark.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class EparkApplicationTests {

	//@Test
	void contextLoads() {
		Vehicle vehicle = new Vehicle();
		vehicle.getBrand().getModel();
	}

}
