package com.metatron.tech.model.Spring_Security.model;


import com.metatron.tech.model.entities.BaseEntity;
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
}
