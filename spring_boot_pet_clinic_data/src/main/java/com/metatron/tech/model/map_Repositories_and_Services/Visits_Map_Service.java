package com.metatron.tech.model.map_Repositories_and_Services;

import com.metatron.tech.model.entities.Visit;
import com.metatron.tech.model.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
@Profile("map")
public class Visits_Map_Service extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Visit> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
          super.deleteById(id);
    }
}
