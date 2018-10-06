package com.metatron.tech.model.services.serviceFactories;



import com.metatron.tech.model.services.*;
import org.springframework.stereotype.Component;

@Component
public class ServiceBeanFactory{
    private  final VetService vetService;
    private  final OwnerService ownerService;
    private  final PetService petService;
    private  final PetTypeService petTypeService;
    private  final SpecialtyService specialtyService;
    private  final  VisitService visitService;

    private final RoleService roleService;
    private final UsersService usersService;

    public ServiceBeanFactory(VetService vetService, OwnerService ownerService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService, RoleService roleService, UsersService usersService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
        this.roleService = roleService;
        this.usersService = usersService;
    }


    public VetService getVetService() {
        return vetService;
    }

    public OwnerService getOwnerService() {
        return ownerService;
    }

    public PetService getPetService() {
        return petService;
    }

    public PetTypeService getPetTypeService() {
        return petTypeService;
    }

    public SpecialtyService getSpecialtyService() {
        return specialtyService;
    }

    public VisitService getVisitService() {
        return visitService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UsersService getUsersService() {
        return usersService;
    }
}
