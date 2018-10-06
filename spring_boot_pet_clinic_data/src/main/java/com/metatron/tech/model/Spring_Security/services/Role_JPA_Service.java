package com.metatron.tech.model.Spring_Security.services;

import com.metatron.tech.model.Spring_Security.model.Role;
import com.metatron.tech.model.Spring_Security.repositories.RoleRepository;
import com.metatron.tech.model.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class Role_JPA_Service implements RoleService {



    private  final RoleRepository roleRepository;

    public Role_JPA_Service(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findAll() {

        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public void delete(Role object) {
        roleRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public Role findByRole(String role){
        return roleRepository.findByRole(role);
    }
}
