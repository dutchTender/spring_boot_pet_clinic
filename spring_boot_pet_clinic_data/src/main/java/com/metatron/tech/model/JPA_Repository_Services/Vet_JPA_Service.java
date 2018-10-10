package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.JPA_Repositories.VetRepository;
import com.metatron.tech.model.entities.Vet;
import com.metatron.tech.model.Services_Interface.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("JPA")
public class Vet_JPA_Service implements VetService {


    private VetRepository vetRepository;
    public Vet_JPA_Service(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vet -> vets.add(vet));

        return vets;
    }

    @Override
    public Optional<Vet> findById(Long id) {


        return vetRepository.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
