package com.app.rentACarApp.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberOfModel")
    private int numberOfModel;

    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL)
    private List<Model> models;
}
