package br.com.park.epark.model;

import br.com.park.epark.enuns.VacancyStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vacancy")
@Data
@NoArgsConstructor
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numberVacancy;

    @Enumerated(EnumType.ORDINAL)
    private VacancyStatus status;

    @ManyToOne
    @JoinColumn(name = "id_parking_price")
    private ParkingPrice parkingPrice;

    @OneToMany(mappedBy = "vacancy", fetch = FetchType.LAZY)
    private List<Parking> parkings;


    public Vacancy(Integer numberVacancy, ParkingPrice parkingPrice) {
        this.numberVacancy = numberVacancy;
        this.parkingPrice = parkingPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberVacancy() {
        return numberVacancy;
    }

    public void setNumberVacancy(Integer numberVacancy) {
        this.numberVacancy = numberVacancy;
    }

    public VacancyStatus getStatus() {
        return status;
    }

    public void setStatus(VacancyStatus status) {
        this.status = status;
    }

    public ParkingPrice getParkingPrice() {
        return parkingPrice;
    }

    public void setParkingPrice(ParkingPrice parkingPrice) {
        this.parkingPrice = parkingPrice;
    }
}
