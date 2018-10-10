package com.metatron.tech.model.JPA_Repositories;

import com.metatron.tech.model.entities.Privilege;
import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    Privilege findByName(String name);

}
