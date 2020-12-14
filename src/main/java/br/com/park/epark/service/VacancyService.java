package br.com.park.epark.service;


import br.com.park.epark.controller.request.VacancyRequest;
import br.com.park.epark.controller.request.VehicleRequest;
import br.com.park.epark.enuns.VacancyStatus;
import br.com.park.epark.model.Vacancy;

import java.util.List;

public interface VacancyService {

    Vacancy create(VacancyRequest request);
    Vacancy findByNumberVacancy(Integer numberVacancy);
    List<Vacancy> findAll();
    Vacancy update(Vacancy vacancy);

}
