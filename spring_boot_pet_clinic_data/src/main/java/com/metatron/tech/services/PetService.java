package com.metatron.tech.services;

import com.metatron.tech.model.Pet;
import org.springframework.stereotype.Component;


@Component
public interface PetService extends CrudService<Pet, Long>{


}
