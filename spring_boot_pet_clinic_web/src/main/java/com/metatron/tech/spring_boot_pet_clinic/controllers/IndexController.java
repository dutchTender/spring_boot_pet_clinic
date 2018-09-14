package com.metatron.tech.spring_boot_pet_clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
       @RequestMapping({"", "/","index", "templates/index.html"})
       public String index(){
           // get owner info
           return "index";
       }

}
