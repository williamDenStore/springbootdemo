package com.example.springbootdemo.repository;

import com.example.springbootdemo.entity.Person;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PersonRepository extends ListCrudRepository<Person, Long> {

    //List<Person> findAllByName(String name);
}
