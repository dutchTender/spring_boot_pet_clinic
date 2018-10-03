package com.metatron.tech.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


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
    private LocalDate birthdate;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
