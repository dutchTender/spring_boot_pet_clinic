package com.metatron.tech.model.Spring_Security;


import com.metatron.tech.model.entities.BaseEntity;
import com.metatron.tech.model.entities.Person;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
@Data
@Entity
@Table(name="user")
public class User extends BaseEntity {
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String username;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    private String passwordConfirm;

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

    @Column(name="active")
    private int active;

    @OneToOne
    private Person person;




}
