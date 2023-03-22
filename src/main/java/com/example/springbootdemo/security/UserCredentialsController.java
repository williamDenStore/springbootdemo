package com.example.springbootdemo.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class UserCredentialsController {
    private PasswordEncoder encoder;
    private UserCredentialsRepository repo;
    public UserCredentialsController(PasswordEncoder encoder, UserCredentialsRepository repo){
        this.encoder = encoder;
        this.repo = repo;
    }
    @PostMapping("/register")
    public ResponseEntity<Void> createUser(UserDto userDto){
        UserCredentials user = new UserCredentials();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        if (repo.findByName(user.getName())!=null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        repo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
