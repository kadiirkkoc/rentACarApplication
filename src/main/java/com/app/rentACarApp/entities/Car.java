package com.app.rentACarApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class    Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dailyPrice")
    private String dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state; // 1-avaliable , 2-rented , 3-maintanance

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "model_id" , referencedColumnName = "id")
    private Model model;

}
