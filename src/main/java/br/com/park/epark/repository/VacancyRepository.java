package br.com.park.epark.repository;


import br.com.park.epark.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    Vacancy findByNumberVacancy(Integer numberVacancy);

}
