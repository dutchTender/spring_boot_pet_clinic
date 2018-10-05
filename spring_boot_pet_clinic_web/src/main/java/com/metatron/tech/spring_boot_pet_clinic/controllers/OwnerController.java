package com.metatron.tech.spring_boot_pet_clinic.controllers;

import com.metatron.tech.model.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners", "/owners/index","/owners/index.html"})
    public String listOwners(Model model){
        // get owner info
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }


    // get parameter from login in form ...
    // use that to find the correct owner bean and add to model
    // we will disable the list all owners section as that does not make any sense for a owner to see all other owners

    @RequestMapping({"/owner"})
    public String listOwner(Model model){

        // get login id

        // use that to find the owner
        // add it to model
        // and return view


        return "my-home";
    }


}
