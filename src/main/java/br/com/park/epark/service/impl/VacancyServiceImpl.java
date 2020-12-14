package br.com.park.epark.service.impl;


import br.com.park.epark.controller.request.VacancyRequest;
import br.com.park.epark.controller.request.VehicleRequest;
import br.com.park.epark.enuns.VacancyStatus;
import br.com.park.epark.model.ParkingPrice;
import br.com.park.epark.model.Vacancy;
import br.com.park.epark.repository.VacancyRepository;
import br.com.park.epark.service.ParkingPriceService;
import br.com.park.epark.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private ParkingPriceService parkingPriceService;

    @Override
    public Vacancy create(VacancyRequest request) {
        Vacancy vacancy = vacancyRepository.findByNumberVacancy(request.getNumberVacancy());
        if (vacancy == null){
            Optional<ParkingPrice> parkingPrice = parkingPriceService.findById(request.getIdParkingPrice());
            if (parkingPrice.isPresent()){
                vacancy = new Vacancy();
                vacancy.setNumberVacancy(request.getNumberVacancy());
                vacancy.setStatus(VacancyStatus.AVAILABLE);
                vacancy.setParkingPrice(parkingPrice.get());
                return vacancyRepository.save(vacancy);
            }
        }
        return vacancy;
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy findByNumberVacancy(Integer numberVacancy) {
        return vacancyRepository.findByNumberVacancy(numberVacancy);
    }

    @Override
    public Vacancy update(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }
}
