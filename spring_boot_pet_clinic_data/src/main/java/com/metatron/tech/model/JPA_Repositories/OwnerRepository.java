package com.metatron.tech.model.JPA_Repositories;

import com.metatron.tech.model.entities.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastname);
}
