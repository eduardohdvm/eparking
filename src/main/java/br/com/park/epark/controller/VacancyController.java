package br.com.park.epark.controller;


import br.com.park.epark.controller.request.VacancyRequest;
import br.com.park.epark.controller.response.ParkingPriceResponse;
import br.com.park.epark.controller.response.VacancyResponse;
import br.com.park.epark.enuns.VacancyStatus;
import br.com.park.epark.model.Vacancy;
import br.com.park.epark.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @PostMapping("/vacancy")
    public VacancyResponse saveVacancy(@RequestBody @Valid VacancyRequest request) {
        Vacancy vacancy = vacancyService.create(request);
        return toResponse(vacancy);
    }
    @GetMapping("/vacancy")
    public List<VacancyResponse> findAll(){
        List<Vacancy> vacancies = vacancyService.findAll();
        List<VacancyResponse> response = new ArrayList<>();
        for(Vacancy vacancy: vacancies) {
            response.add(toResponse(vacancy));
        }
        return response;
    }

    private VacancyResponse toResponse(Vacancy vacancy) {
        VacancyResponse vacancyResponse = new VacancyResponse();
        vacancyResponse.setId(vacancy.getId());
        vacancyResponse.setNumberVacancy(vacancy.getNumberVacancy());
        vacancyResponse.setStatus(vacancy.getStatus());
        vacancyResponse.setParkingPrice(
                new ParkingPriceResponse(
                        vacancy.getParkingPrice().getId(),
                        vacancy.getParkingPrice().getFeeHour(),
                        vacancy.getParkingPrice().getFeeNextHour(),
                        vacancy.getParkingPrice().getDescription()

                )
        );
        return vacancyResponse;
    }


}
