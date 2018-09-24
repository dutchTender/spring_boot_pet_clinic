package com.metatron.tech.config;


import com.metatron.tech.model.map.OwnerServiceMap;
import com.metatron.tech.model.map.PetServiceMap;
import com.metatron.tech.model.map.VetServiceMap;
import com.metatron.tech.services.OwnerService;
import com.metatron.tech.services.PetService;
import com.metatron.tech.services.ServiceBeanFactory;
import com.metatron.tech.services.VetService;

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
    public VetService getVetService(){


        Object vetService;
        try {
            Class<?> clazz = Class.forName(vetServiceClass);
            vetService = (VetService) clazz.newInstance();
        } catch (ReflectiveOperationException ex) {
            System.out.println("no VetService bean found!!! default VetService implementation injected");
            vetService = new VetServiceMap();
        }

        return  (VetService) vetService;
    }



    /*DI for OwnerService
     * Spring container will call this method when a type of OwnerService is requested by the spring context */
    @Bean
    public OwnerService getOwnerService(){
        Object ownerService;
        try{
            Class<?> clazz = Class.forName(ownerServiceClass);
            ownerService = (OwnerService) clazz.newInstance();
        }
        catch(ReflectiveOperationException ex){
            System.out.println("no OwnerService bean found!!!! default OwnerService implementation injected");
            ownerService = new OwnerServiceMap();

        }
         return (OwnerService) ownerService;

    }


    /*DI for PetService
     * Spring container will call this method when a type of PetService is requested by the spring context */
    @Bean
    public PetService getPetService(){

        Object petService;
        try{
            Class<?> clazz = Class.forName(petServiceClass);
            petService = (PetService) clazz.newInstance();
        }
        catch(ReflectiveOperationException ex){
            System.out.println("no PetService bean found!!!! default PetService implementation injected");
            petService = new PetServiceMap();

        }
        return (PetService) petService;

    }






}
