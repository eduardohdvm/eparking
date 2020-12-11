package br.com.park.epark.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column
    private Double value;
    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;
    @Column
    private String timeRemains;
    @ManyToOne
    @JoinColumn(name = "id_vacancy")
    private Vacancy vacancy;


    public Parking(){}

    public Parking(Long id, LocalDateTime startDate, LocalDateTime endDate, Double value, Vehicle vehicle) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.value = value;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTimeRemains() {
        return timeRemains;
    }

    public void setTimeRemains(String timeRemains) {
        this.timeRemains = timeRemains;
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
