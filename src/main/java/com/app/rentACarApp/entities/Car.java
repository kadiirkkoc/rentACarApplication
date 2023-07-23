package com.app.rentACarApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    private String dailyPrice;

    private int modelYear;

    private int state; // 1-avaliable , 2-rented , 3-maintanance

    @ManyToOne
    @JoinColumn(name = "model_id" , referencedColumnName = "id")
    private Model model;

}
