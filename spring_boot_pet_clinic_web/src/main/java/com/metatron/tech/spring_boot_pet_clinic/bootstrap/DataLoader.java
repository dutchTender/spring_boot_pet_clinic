package com.metatron.tech.spring_boot_pet_clinic.bootstrap;


import com.metatron.tech.model.Spring_Security.UserService;
import com.metatron.tech.model.Spring_Security.model.Role;
import com.metatron.tech.model.Spring_Security.model.User;
import com.metatron.tech.model.Spring_Security.repositories.RoleRepository;
import com.metatron.tech.model.entities.Owner;
import com.metatron.tech.model.entities.Vet;
import com.metatron.tech.model.services.OwnerService;
import com.metatron.tech.model.services.RoleService;
import com.metatron.tech.model.services.serviceFactories.ServiceBeanFactory;
import com.metatron.tech.model.services.VetService;
import com.metatron.tech.model.services.serviceFactories.UsersService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader  implements ApplicationListener<ContextRefreshedEvent> {


    /*Constructor DI for ServiceBeanFactoryClass*/
    public DataLoader(ServiceBeanFactory serviceBeanFactory) {
        this.serviceBeanFactory = serviceBeanFactory;
    }

    private ServiceBeanFactory serviceBeanFactory;






    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {


        OwnerService myOwnerService = serviceBeanFactory.getOwnerService();
        VetService   myVetService = serviceBeanFactory.getVetService();

        RoleService myRoleService = serviceBeanFactory.getRoleService();
        UsersService myUsersService = serviceBeanFactory.getUsersService();


        // creat user and and role service and make it available in serviceBeanFactory

        // prepare roleRepository  "admin", "owner", "vet"

        Role adminRole = new Role();
        adminRole.setRole("admin");
        myRoleService.save(adminRole);

        Role ownerRole = new Role();
        ownerRole.setRole("owner");
        myRoleService.save(ownerRole);

        Role vetRole = new Role();
        vetRole.setRole("vet");
        myRoleService.save(vetRole);
        // add roles into role repository

        Owner owner1 = new Owner();
        owner1.setFirstName("Li");
        owner1.setLastName("Zhang");
        owner1.setAddress("1115 Reserve Champion Drive");
        owner1.setCity("Rockville");
        owner1.setTelephone("571-839-3730");

        // set username, password, email and role
        User ownerCreds = new User();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        // follow the same convention from the save method and save role for test user 1
        ownerCreds.setUsername("zhangl");
        ownerCreds.setPassword(bCryptPasswordEncoder.encode("xxxxx"));
        ownerCreds.setPasswordConfirm(bCryptPasswordEncoder.encode("xxxxx"));
        ownerCreds.setEmail("lzhang421@gmail.com");
        ownerCreds.setActive(1);

        Role userRole = new Role();
        userRole.setRole("admin");
        myRoleService.save(userRole);
        ownerCreds.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        // create bi-directional relationship between credentials and owner
        ownerCreds.setPerson(owner1);
        owner1.setUser(ownerCreds);
        myRoleService.save(userRole);
        myOwnerService.save(owner1);
        myUsersService.save(ownerCreds);

        // now add objects to repository, owner and user




        // repeat the same for this owner


        Owner owner2 = new Owner();
        owner2.setLastName("Eskola");
        owner2.setFirstName("Brianna");
        owner2.setAddress("1115 Reserve Champion Drive");
        owner2.setCity("Rockville");
        owner2.setTelephone("703-676-7650");


        myOwnerService.save(owner2);


        Vet vet1 = new Vet();
        vet1.setFirstName("Carolyn");
        vet1.setLastName("weston");
        vet1.setAddress("1115 Piccard Ave");
        vet1.setCity("Gaithersburg");
        vet1.setTelephone("3240-567-7755");


        myVetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Jacob");
        vet2.setLastName("Finnerman");
        vet2.setAddress("333 Wisconsion Ave");
        vet2.setCity("Bethesda");
        vet2.setTelephone("301-555-3555");

        myVetService.save(vet2);



    }









}
