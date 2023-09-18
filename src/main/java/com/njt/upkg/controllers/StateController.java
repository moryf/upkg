package com.njt.upkg.controllers;


import com.njt.upkg.domain.ProjectState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/state")
@CrossOrigin
public class StateController {


    @GetMapping("/all")
    public ResponseEntity<?> getAllStates() {
        return ResponseEntity.ok(ProjectState.values());
    }
}
