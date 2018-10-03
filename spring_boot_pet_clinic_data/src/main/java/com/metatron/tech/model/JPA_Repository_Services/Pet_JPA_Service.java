package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.JPA_Repositories.PetRepository;
import com.metatron.tech.model.entities.Pet;
import com.metatron.tech.model.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("JPA")
public class Pet_JPA_Service implements PetService {



    private final PetRepository petRepository;

    public Pet_JPA_Service(PetRepository petRepository) {
        this.petRepository = petRepository;
    }



    @Override
    public Set<Pet> findAll() {

        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
