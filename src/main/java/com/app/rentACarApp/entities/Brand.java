package com.app.rentACarApp.entities;


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

    @JsonManagedReference
    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL)
    private List<Model> models;
}
