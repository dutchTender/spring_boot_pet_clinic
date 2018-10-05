package com.metatron.tech.model.entities;



import com.metatron.tech.model.Spring_Security.User;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Setter
@Getter
@Entity

public class Person  extends BaseEntity{

    @Column(name = "first_name")

    private String firstName;

    @Column(name = "last_name")

    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="telephone")
    private String telephone;

    // add image object for user profile picture

    @OneToOne(cascade = CascadeType.ALL)
    private User user;


}
