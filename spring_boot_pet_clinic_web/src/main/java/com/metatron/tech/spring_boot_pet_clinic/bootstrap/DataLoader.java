package com.metatron.tech.spring_boot_pet_clinic.bootstrap;


import com.metatron.tech.model.entities.Owner;
import com.metatron.tech.model.entities.SecurityCredentials;
import com.metatron.tech.model.entities.Vet;
import com.metatron.tech.model.services.OwnerService;
import com.metatron.tech.model.services.serviceFactories.ServiceBeanFactory;
import com.metatron.tech.model.services.VetService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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





        Owner owner1 = new Owner();
        owner1.setFirstName("Li");
        owner1.setLastName("Zhang");
        owner1.setAddress("1115 Reserve Champion Drive");
        owner1.setCity("Rockville");
        owner1.setTelephone("571-839-3730");

        SecurityCredentials securityCredentials = new SecurityCredentials();
        securityCredentials.setPass_word("xxx");
        securityCredentials.setUser_id("lzhang421");
        securityCredentials.setRole("owner");

        owner1.setSecurityCredentials(securityCredentials);

        myOwnerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setLastName("Eskola");
        owner2.setFirstName("Brianna");
        owner2.setAddress("1115 Reserve Champion Drive");
        owner2.setCity("Rockville");
        owner2.setTelephone("703-676-7650");

        SecurityCredentials securityCredentials1 = new SecurityCredentials();
        securityCredentials1.setUser_id("brieskola");
        securityCredentials1.setPass_word("yyy");
        securityCredentials1.setRole("owner");
        owner2.setSecurityCredentials(securityCredentials1);
        myOwnerService.save(owner2);


        Vet vet1 = new Vet();
        vet1.setFirstName("Carolyn");
        vet1.setLastName("weston");
        vet1.setAddress("1115 Piccard Ave");
        vet1.setCity("Gaithersburg");
        vet1.setTelephone("3240-567-7755");

        SecurityCredentials securityCredentials2 = new SecurityCredentials();
        securityCredentials2.setUser_id("cweston");
        securityCredentials2.setPass_word("zzz");
        securityCredentials2.setRole("vet");
        vet1.setSecurityCredentials(securityCredentials2);
        myVetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Jacob");
        vet2.setLastName("Finnerman");
        vet2.setAddress("333 Wisconsion Ave");
        vet2.setCity("Bethesda");
        vet2.setTelephone("301-555-3555");
        SecurityCredentials securityCredentials3 = new SecurityCredentials();
        securityCredentials3.setUser_id("jfine");
        securityCredentials3.setPass_word("aaa");
        securityCredentials3.setRole("vet");
        vet2.setSecurityCredentials(securityCredentials3);
        myVetService.save(vet2);



    }









}
