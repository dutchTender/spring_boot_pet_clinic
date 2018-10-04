package com.metatron.tech.model.entities;



import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class SecurityCredentials extends BaseEntity {

    private String user_id;
    private String pass_word;
    private String role;



    @OneToOne(mappedBy = "securityCredentials")
    private Person person;



    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
