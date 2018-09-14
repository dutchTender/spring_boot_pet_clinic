package com.metatron.tech.spring_boot_pet_clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping({"", "/","owners", "owners/index.html"})
    public String listOwners(){
        // get owner info
        return "owners/index";
    }
}
