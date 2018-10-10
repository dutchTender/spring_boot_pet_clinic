package com.metatron.tech.model.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;



@Data
@Entity
@Table(name = "privilege")
public class Privilege extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

}
