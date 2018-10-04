package com.metatron.tech.model.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "owners")
public class Owner extends Person {


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //  the Pet object will have a property called 'owner' to reference back
    private Set<Pet> pets = new HashSet<>();


}
