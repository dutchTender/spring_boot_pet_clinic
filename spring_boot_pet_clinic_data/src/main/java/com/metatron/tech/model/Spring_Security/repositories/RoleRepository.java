package com.metatron.tech.model.Spring_Security.repositories;


import com.metatron.tech.model.Spring_Security.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role, Long> {

    Role findByRole(String role);
}
