package com.metatron.tech.spring_boot_pet_clinic.bootstrap;


import com.metatron.tech.model.entities.Privilege;
import com.metatron.tech.model.entities.Role;
import com.metatron.tech.model.entities.User;
import com.metatron.tech.model.entities.Owner;
import com.metatron.tech.model.entities.Vet;
import com.metatron.tech.model.Services_Interface.OwnerService;
import com.metatron.tech.model.Services_Interface.PrivilegeService;
import com.metatron.tech.model.Services_Interface.RoleService;
import com.metatron.tech.model.Services_Interface.serviceFactories.ServiceBeanFactory;
import com.metatron.tech.model.Services_Interface.VetService;
import com.metatron.tech.model.Services_Interface.serviceFactories.UsersService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader  implements ApplicationListener<ContextRefreshedEvent> {


    /*Constructor DI for ServiceBeanFactoryClass*/
    public DataLoader(ServiceBeanFactory serviceBeanFactory) {
        this.serviceBeanFactory = serviceBeanFactory;
    }

    private ServiceBeanFactory serviceBeanFactory;






    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {


        OwnerService myOwnerService = serviceBeanFactory.getOwnerService();
        VetService   myVetService = serviceBeanFactory.getVetService();

        RoleService myRoleService = serviceBeanFactory.getRoleService();
        UsersService myUsersService = serviceBeanFactory.getUsersService();

        PrivilegeService myPrivilegeService = serviceBeanFactory.getPrivilegeService();

        // creat user and and role service and make it available in serviceBeanFactory

        // prepare roleRepository  "admin", "owner", "vet"

        //Role adminRole = new Role();
        //adminRole.setRole("admin");
        //myRoleService.save(adminRole);

        //Role ownerRole = new Role();
        //ownerRole.setRole("owner");
        //myRoleService.save(ownerRole);

        //Role vetRole = new Role();
        //vetRole.setRole("vet");
        //myRoleService.save(vetRole);
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
        myOwnerService.save(owner1);
        myUsersService.save(ownerCreds);
        myRoleService.save(userRole);



        // now add objects to repository, owner and user



        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        HashSet<Privilege>   adminPrivileges= new HashSet<Privilege>(Arrays.asList(
                readPrivilege, writePrivilege));
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", new HashSet<Privilege>(Arrays.asList(readPrivilege)));

        Role adminRole = myRoleService.findByRole("ROLE_ADMIN");
        User user = new User();
        //user.setFirstName("Test");
        //user.setLastName("Test");
        user.setUsername("test_user");
        user.setPassword(bCryptPasswordEncoder.encode("test123"));
        user.setEmail("test@test.com");
        user.setRoles( new HashSet<Role>(Arrays.asList(adminRole)));
        user.setActive(1);
        myUsersService.save(user);








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



    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        PrivilegeService privilegeService = serviceBeanFactory.getPrivilegeService();

        Privilege privilege = privilegeService.findByName(name);
        if (privilege == null) {
            privilege = new Privilege();
            privilege.setName(name);
            privilegeService.save(privilege);
        }
        return privilege;
    }


    @Transactional
    Role createRoleIfNotFound(
            String name, Set<Privilege> privileges) {

        RoleService roleService = serviceBeanFactory.getRoleService();
        Role role = roleService.findByRole(name);
        if (role == null) {
            role = new Role();
            role.setRole(name);
            role.setPrivileges(privileges);
            roleService.save(role);
        }
        return role;
    }





}
