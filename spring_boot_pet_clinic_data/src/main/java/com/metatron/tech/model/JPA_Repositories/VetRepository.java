package com.metatron.tech.model.JPA_Repositories;

import com.metatron.tech.model.entities.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
