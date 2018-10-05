package com.metatron.tech.spring_boot_pet_clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
       @RequestMapping({"", "/","/index","/index.html", "/home"})
       public String index(){
           // get owner info
           System.out.println("#############################################################");
           return "index";
       }


       @RequestMapping({"/login"})
        public String login(){

           System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
           return "login";
       }


    @RequestMapping({"/logoutHome"})
    public String logout(){

        System.out.println("1111111111111111111111111111111111111111111111111111111");
        return "welcome";
    }
}
