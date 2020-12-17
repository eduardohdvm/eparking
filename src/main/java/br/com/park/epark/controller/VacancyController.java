package br.com.park.epark.controller;


import br.com.park.epark.controller.request.VacancyRequest;
import br.com.park.epark.controller.response.VacancyResponse;
import br.com.park.epark.model.Vacancy;
import br.com.park.epark.service.VacancyService;
import br.com.park.epark.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;


    @PostMapping("/vacancy")
    public VacancyResponse saveVacancy(@RequestBody @Valid VacancyRequest request) {
        Vacancy vacancy = vacancyService.create(request);
        return ResponseUtils.toResponse(vacancy);
    }
    @GetMapping("/vacancy")
    public List<VacancyResponse> findAll(){
        List<Vacancy> vacancies = vacancyService.findAll();
        List<VacancyResponse> response = new ArrayList<>();
        for(Vacancy vacancy: vacancies) {
            response.add(ResponseUtils.toResponse(vacancy));
        }
        return response;
    }


}
