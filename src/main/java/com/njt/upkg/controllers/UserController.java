package com.njt.upkg.controllers;

import com.njt.upkg.domain.LoginRequest;
import com.njt.upkg.domain.User;
import com.njt.upkg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.getUsername() + " " + loginRequest.getPassword());
        Optional<User> user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid username/password");
        }
        return ResponseEntity.ok(user);
    }
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }


}
