package com.metatron.tech.model.map_Repositories_and_Services;

import com.metatron.tech.model.entities.Owner;
import com.metatron.tech.model.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;


@Service
@Profile("map")
public class Owner_Map_Service extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return super.findAll();
    }

    @Override
    public Optional<Owner> findById(Long id) {

        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
                super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
