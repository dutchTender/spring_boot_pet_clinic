package com.metatron.tech.services;

import com.metatron.tech.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findall();
}
