package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.JPA_Repositories.SpecialtyRepository;
import com.metatron.tech.model.entities.Speciality;
import com.metatron.tech.model.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("JPA")
public class Specialty_JPA_Service implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public Specialty_JPA_Service(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {

        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Optional<Speciality> findById(Long id) {
        return specialtyRepository.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
