package com.metatron.tech.spring_boot_pet_clinic.controllers;

import com.metatron.tech.services.OwnerService;
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

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
