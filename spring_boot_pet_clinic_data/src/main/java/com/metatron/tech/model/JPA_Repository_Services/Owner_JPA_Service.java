package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.JPA_Repositories.OwnerRepository;
import com.metatron.tech.model.JPA_Repositories.PetRepository;
import com.metatron.tech.model.JPA_Repositories.PetTypeRepository;
import com.metatron.tech.model.entities.Owner;
import com.metatron.tech.model.services.OwnerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Profile("JPA")
public class Owner_JPA_Service implements OwnerService {

    ////////////////////////////////////////////////////////////////////////////
    // DI for spring JPA
    ////////////////////////////////////////////////////////////////////////////
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public Owner_JPA_Service(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }
    ///////////////////////////////////////////////////////////////////////////



    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    public PetRepository getPetRepository() {
        return petRepository;
    }

    public PetTypeRepository getPetTypeRepository() {
        return petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return  ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owner -> owners.add(owner));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        return owners;
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return  ownerRepository.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {

        ownerRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {

        ownerRepository.deleteById(id);

    }
}
