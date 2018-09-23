package com.metatron.tech.config;


import com.metatron.tech.model.map.OwnerServiceMap;
import com.metatron.tech.model.map.PetServiceMap;
import com.metatron.tech.model.map.VetServiceMap;
import com.metatron.tech.services.OwnerService;
import com.metatron.tech.services.PetService;
import com.metatron.tech.services.VetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesBeanConfig {
    /*DI for VetService
     * Spring container will call this method when a type of VetService is requested by the spring context */
    @Bean
    public VetService getVetService(){

        return new VetServiceMap();
    }

    /*DI for OwnerService
     * Spring container will call this method when a type of OwnerService is requested by the spring context */
    @Bean
    public OwnerService getOwnerService(){

        return new OwnerServiceMap();
    }
    /*DI for PetService
     * Spring container will call this method when a type of PetService is requested by the spring context */
    @Bean
    public PetService getPetService(){
        return new PetServiceMap();
    }
}
