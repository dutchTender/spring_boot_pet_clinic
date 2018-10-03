package com.metatron.tech.model.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="vets")
public class Vet extends Person {


    @ManyToMany    // need to specifiy join column and inverse join column ... the other side needs mapped by  'specialities'
    @JoinTable(name ="vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name="speciality_id") )
    private Set<Speciality> specialities = new HashSet<>();


    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
