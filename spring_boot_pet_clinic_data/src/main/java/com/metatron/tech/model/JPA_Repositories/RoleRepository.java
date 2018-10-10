package com.metatron.tech.model.JPA_Repositories;


import com.metatron.tech.model.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role, Long> {

    Role findByRole(String role);

}
