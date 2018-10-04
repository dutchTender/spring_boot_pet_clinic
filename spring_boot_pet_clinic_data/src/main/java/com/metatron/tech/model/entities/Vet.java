package com.metatron.tech.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name="vets")
public class Vet extends Person {


    @ManyToMany    // need to specifiy join column and inverse join column ... the other side needs mapped by  'specialities'
    @JoinTable(name ="vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name="speciality_id") )
    private Set<Speciality> specialities = new HashSet<>();


}
