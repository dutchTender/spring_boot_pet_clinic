package com.metatron.tech.spring_boot_pet_clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

/* below annotations are used for finding beabs in the data module*/
@EnableJpaRepositories(basePackages = {"com.metatron.tech"})
@EntityScan(basePackages = {"com.metatron.tech"})
@ComponentScan(basePackages = {"com.metatron.tech"})



public class SpringBootPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPetClinicApplication.class, args);
    }
}
