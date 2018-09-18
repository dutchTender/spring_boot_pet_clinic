package com.metatron.tech.spring_boot_pet_clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class VetController {

    @RequestMapping({"", "/","/vets","/vets/index", "/vets/index.html"})
    public String listVets(){
        // get owner info
        return "vets/index";
    }
}
