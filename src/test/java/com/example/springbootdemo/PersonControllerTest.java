
package com.example.springbootdemo;

import com.example.springbootdemo.entity.Person;
import com.example.springbootdemo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;



import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = PersonControllerTest.class)
class PersonControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonRepository personRepository;

    @Test
    void getPersonsShouldReturnListOfAllPersons() throws Exception {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setName("pelle");
        Person person2 = new Person();
        person1.setId(2L);
        person1.setName("kalle");
        when(personRepository.findAll()).thenReturn(List.of(person1, person2));

        mockMvc.perform(get("/names"))
                .andExpect(status().isOk());
    }
    @Test
    void getPersonByIdTest(){
        Person person1 = new Person();
        person1.setId(1L);
        person1.setName("pelle");

        when(personRepository.findById(1L)).thenReturn(Optional.of(person1));

    }
}
