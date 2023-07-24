package com.app.rentACarApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private int numberOfCar;

    private int year;

    @ManyToOne
    @JoinColumn(name = "brand_id" , referencedColumnName = "id")
    private Brand brand;

    @OneToMany(mappedBy = "model" , cascade = CascadeType.ALL)
    private List<Car> cars;
}
