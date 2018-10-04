package com.metatron.tech.model.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name="petType")
public class PetType extends BaseEntity {


    @Column(name="name")
    private String name;

}
