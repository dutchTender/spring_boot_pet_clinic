package com.metatron.tech.model.Spring_Security;


import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role, Long> {

    Role findByRole(String role);
}
