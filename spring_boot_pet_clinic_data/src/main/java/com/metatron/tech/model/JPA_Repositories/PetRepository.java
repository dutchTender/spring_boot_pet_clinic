package com.metatron.tech.model.JPA_Repositories;

import com.metatron.tech.model.entities.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository <Pet, Long> {
}
