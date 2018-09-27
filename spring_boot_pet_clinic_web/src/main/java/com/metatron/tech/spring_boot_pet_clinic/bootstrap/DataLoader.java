package com.metatron.tech.spring_boot_pet_clinic.bootstrap;


import com.metatron.tech.model.entities.Owner;
import com.metatron.tech.model.entities.Vet;
import com.metatron.tech.model.services.OwnerService;
import com.metatron.tech.model.services.ServiceBeanFactory;
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
        myOwnerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setLastName("Eskola");
        owner2.setFirstName("Brianna");
        myOwnerService.save(owner2);


        Vet vet1 = new Vet();
        vet1.setFirstName("Carolyn");
        vet1.setLastName("weston");
        myVetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jacob");
        vet2.setLastName("Finnerman");
        myVetService.save(vet2);



    }









}
