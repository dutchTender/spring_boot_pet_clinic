package com.metatron.tech.model.JPA_Repositories;

import com.metatron.tech.model.entities.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepsitory extends CrudRepository<Owner, Long> {
}
