package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.JPA_Repositories.PetTypeRepository;
import com.metatron.tech.model.entities.PetType;
import com.metatron.tech.model.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("JPA")
public class PetType_JPA_Service implements PetTypeService {


    PetTypeRepository petTypeRepository;

    public PetType_JPA_Service(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {

        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public Optional<PetType> findById(Long id) {
        return petTypeRepository.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
