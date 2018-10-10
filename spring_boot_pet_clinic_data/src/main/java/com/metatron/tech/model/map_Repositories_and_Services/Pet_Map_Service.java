package com.metatron.tech.model.map_Repositories_and_Services;

import com.metatron.tech.model.entities.Pet;

import com.metatron.tech.model.Services_Interface.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;


@Service
@Profile("map")
public class Pet_Map_Service extends AbstractMapService<Pet, Long> implements PetService{


    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
      return   super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
