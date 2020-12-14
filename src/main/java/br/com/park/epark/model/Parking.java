package br.com.park.epark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer timeRemains;
    @ManyToOne
    @JoinColumn(name = "id_vacancy")
    private Vacancy vacancy;

}