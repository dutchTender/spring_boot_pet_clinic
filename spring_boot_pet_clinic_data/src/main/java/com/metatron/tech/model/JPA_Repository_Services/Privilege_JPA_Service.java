package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.entities.Privilege;
import com.metatron.tech.model.JPA_Repositories.PrivilegeRepository;
import com.metatron.tech.model.Services_Interface.PrivilegeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class Privilege_JPA_Service implements PrivilegeService {


    private  final PrivilegeRepository privilegeRepository;

    public Privilege_JPA_Service(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public Privilege findByName(String name) {
        return privilegeRepository.findByName(name);
    }

    @Override
    public Set<Privilege> findAll() {

        Set<Privilege> privileges = new HashSet<>();
        privilegeRepository.findAll().forEach(privileges::add);

        return privileges;
    }

    @Override
    public Optional<Privilege> findById(Long id) {
        return privilegeRepository.findById(id);
    }

    @Override
    public Privilege save(Privilege object) {
        return privilegeRepository.save(object);
    }

    @Override
    public void delete(Privilege object) {
            privilegeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
            privilegeRepository.deleteById(id);
    }
}
