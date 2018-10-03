package com.metatron.tech.model.map_Repositories;

import com.metatron.tech.model.entities.Vet;
import com.metatron.tech.model.services.VetService;

import java.util.Optional;
import java.util.Set;



public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Vet> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }
}
