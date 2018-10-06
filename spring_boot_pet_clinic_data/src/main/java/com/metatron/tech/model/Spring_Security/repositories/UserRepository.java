package com.metatron.tech.model.Spring_Security.repositories;


import com.metatron.tech.model.Spring_Security.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
