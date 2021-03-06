package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.entities.User;
import com.metatron.tech.model.JPA_Repositories.UserRepository;
import com.metatron.tech.model.Services_Interface.serviceFactories.UsersService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class User_JPA_Service implements UsersService {


    private  final UserRepository userRepository;

    public User_JPA_Service(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
