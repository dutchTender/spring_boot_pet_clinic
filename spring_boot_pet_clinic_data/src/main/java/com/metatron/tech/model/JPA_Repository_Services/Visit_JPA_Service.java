package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.JPA_Repositories.VisitRepository;
import com.metatron.tech.model.entities.Visit;
import com.metatron.tech.model.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("JPA")
public class Visit_JPA_Service implements VisitService {

    VisitRepository visitRepository;

    public Visit_JPA_Service(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {

        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Optional<Visit> findById(Long id) {
        return visitRepository.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
