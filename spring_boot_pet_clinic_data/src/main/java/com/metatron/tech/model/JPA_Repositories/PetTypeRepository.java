package com.metatron.tech.model.JPA_Repositories;

import com.metatron.tech.model.entities.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
