package com.metatron.tech.services;


import org.springframework.stereotype.Component;

@Component
public class ServiceBeanFactory {

    private  final  VetService vetService;
    private  final  OwnerService ownerService;
    private  final  PetService petService;


    public ServiceBeanFactory(VetService vetService, OwnerService ownerService, PetService petService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petService = petService;
    }



    public VetService getVetService(){

        return vetService;
    }

    public OwnerService getOwnerService(){

        return ownerService;
    }


    public PetService getPetService(){

        return petService;
    }
}
