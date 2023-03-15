package com.example.springbootdemo.controller;

import com.example.springbootdemo.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    PersonRepository repo;

    public WebController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping(path = "/showPersons")
    String persons(Model model){
        model.addAttribute("message","test123");
        model.addAttribute("allpersons", repo.findAll());
        return "persons";
    }
}
