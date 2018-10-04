package com.metatron.tech.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name="pets")
public class Pet extends BaseEntity {

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "petType_id")   // PetType will need to mappedBy  'petType' attribute
    private PetType petType;

    @ManyToOne
    @JoinColumn(name="owner_id")  // Owner will need a mappedBy 'owner' attribue
    private Owner owner;

    @Column(name="birth_date")
    private LocalDate birth_date;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();


}
