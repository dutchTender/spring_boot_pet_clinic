package com.metatron.tech.model.JPA_Repositories;

import com.metatron.tech.model.entities.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
