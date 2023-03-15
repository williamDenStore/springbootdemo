package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Person;
import com.example.springbootdemo.repository.PersonRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/names")
public class PersonController {

    PersonRepository repo;
    public PersonController(PersonRepository personRepository){
        repo = personRepository;
    }
    @GetMapping("/{id}")
    Person getAName(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }
    @GetMapping()
    List<Person> getAllNames(){
        return repo.findAll();
    }
    @PostMapping
    void addName(@RequestBody Person person){
        String name = person.getName();
        repo.save(person);
    }
    @GetMapping("/lang")
    String preferedLanguage(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String lang){
        return lang;
    }
}
