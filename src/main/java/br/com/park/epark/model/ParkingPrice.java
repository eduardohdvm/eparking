package br.com.park.epark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParkingPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column
    private Double feeHour;

    @OneToMany
    @JsonIgnore
    @Fetch(FetchMode.SUBSELECT)
    private List<Vacancy> vacancies;

    @Transient
    private List<Vacancy> vacanciesTransient;

    public ParkingPrice(String description) {
        this.description = description;
    }
}
