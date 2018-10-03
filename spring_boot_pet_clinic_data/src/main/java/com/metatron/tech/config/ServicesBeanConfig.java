package com.metatron.tech.config;


import com.metatron.tech.model.JPA_Repositories.OwnerRepository;
import com.metatron.tech.model.JPA_Repositories.PetRepository;
import com.metatron.tech.model.JPA_Repositories.PetTypeRepository;
import com.metatron.tech.model.JPA_Repositories.VetRepository;
import com.metatron.tech.model.JPA_Repository_Services.Owner_JPA_Service;
import com.metatron.tech.model.JPA_Repository_Services.Pet_JPA_Service;
import com.metatron.tech.model.JPA_Repository_Services.Vet_JPA_Service;
import com.metatron.tech.model.map_Repositories.PetServiceMap;
import com.metatron.tech.model.map_Repositories.VetServiceMap;
import com.metatron.tech.model.services.OwnerService;
import com.metatron.tech.model.services.PetService;
import com.metatron.tech.model.services.ServiceBeanFactory;
import com.metatron.tech.model.services.VetService;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:services.properties")
public class ServicesBeanConfig {





    @Value("${OwnerServiceImpl}")
    String ownerServiceClass;

    @Value("${PetServiceImpl}")
    String petServiceClass;

    @Value("${VetServiceImpl}")
    String vetServiceClass;




    /* this is the bean class that will match up the values from the properties file to our annontationed variables */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){

        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }


    /*create a test bean and inject that returns some bean like below...
    * but before returning. set the values from the property file...this will allow that singleton bean to get the property
    * file value each time it is loaded by spring*/

    /*also test out the applicationContextFactory method again ...make sure we are actually getting values from the property
    * file for the bean not found exception*/




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*DI for ServiceBeanFactory ..which will call the 3 services below to initialize its constructor parameter list*/
    @Bean
    ServiceBeanFactory getServiceBeanFactory(VetService vetService, OwnerService ownerService, PetService petService){
        return new ServiceBeanFactory(vetService,ownerService, petService);
    }


    /*DI for VetService
     * Spring container will call this method when a type of VetService is requested by the spring context */
    @Bean
    public VetService getVetService(VetRepository vetRepository){


     //return new VetServiceMap();
return new Vet_JPA_Service(vetRepository);

}
    /*DI for OwnerService
     * Spring container will call this method when a type of OwnerService is requested by the spring context */
    @Bean
    public OwnerService getOwnerService(OwnerRepository ownerRepsitory, PetRepository petRepository, PetTypeRepository petTypeRepository){
          return new Owner_JPA_Service(ownerRepsitory, petRepository, petTypeRepository);
            //return new OwnerServiceMap();  // map implementation
    }


    /*DI for PetService
     * Spring container will call this method when a type of PetService is requested by the spring context */
    @Bean
    public PetService getPetService(PetRepository petRepository){

        //return new PetServiceMap();
        return new Pet_JPA_Service(petRepository);

    }

}

