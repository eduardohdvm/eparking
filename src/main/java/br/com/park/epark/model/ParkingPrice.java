package br.com.park.epark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column
    private Double feeHour;
    @Column
    private Double feeNextHour;

    @OneToMany
    @JsonIgnore
    @Fetch(FetchMode.SUBSELECT)
    private List<Vacancy> vacancies;

    @Transient
    private List<Vacancy> vacanciesTransient;


}
