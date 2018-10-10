package com.metatron.tech.model.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name="role")
public class Role  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Column(name="role")
    private String role;


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "role_prvileges",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id")
    )

    private Set<Privilege> privileges;
}
