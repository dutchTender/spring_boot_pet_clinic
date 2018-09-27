package com.metatron.tech.model.services;


public class ServiceBeanFactory {

    private  final  VetService vetService;
    private  final  OwnerService ownerService;
    private  final  PetService petService;

    /* Constructor DI for VetService, OwnerService, PetService*/
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
