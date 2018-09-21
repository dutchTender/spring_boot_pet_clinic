package com.metatron.tech.spring_boot_pet_clinic.bootstrap;


import com.metatron.tech.model.Owner;
import com.metatron.tech.model.Vet;
import com.metatron.tech.services.OwnerService;
import com.metatron.tech.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements ApplicationListener<ContextRefreshedEvent> {

     private final OwnerService ownerService;



     private final VetService vetService;



    public DataLoader( OwnerService ownerService,VetService vetService ) {
        this.ownerService = ownerService;
        this.vetService = vetService;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Owner owner1 = new Owner();

        owner1.setFirstName("Li");
        owner1.setLastName("Zhang");
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setLastName("Eskola");
        owner2.setFirstName("Brianna");
        ownerService.save(owner2);


        Vet vet1 = new Vet();

        vet1.setFirstName("Carolyn");
        vet1.setLastName("weston");
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Jacob");
        vet2.setLastName("Finnerman");
        vetService.save(vet2);
    }









}
