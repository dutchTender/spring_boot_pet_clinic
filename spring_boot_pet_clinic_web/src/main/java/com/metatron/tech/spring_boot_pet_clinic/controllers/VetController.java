package com.metatron.tech.spring_boot_pet_clinic.controllers;

import com.metatron.tech.model.services.VetService;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets.html", "/vets/index", "/vets/index.html"})
    public String listVets(Model model){
        // get owner info
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
