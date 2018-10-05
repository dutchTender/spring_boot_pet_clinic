package com.metatron.tech.model.Spring_Security;


import com.metatron.tech.model.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
@Data
@Entity
@Table(name="role")
public class Role extends BaseEntity {

    @Column(name="role")
    private String role;
}
