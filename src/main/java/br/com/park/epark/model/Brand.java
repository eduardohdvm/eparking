package br.com.park.epark.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String model;
    @Column
    private String brand;

    private Brand(){}

    @ManyToMany
    private List<Vehicle> vehicle;

    public Brand(Long id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brands) {
        this.brand = brands;
    }

}
