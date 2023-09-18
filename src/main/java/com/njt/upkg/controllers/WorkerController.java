package com.njt.upkg.controllers;

import com.njt.upkg.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/worker")
public class WorkerController {
    private final WorkerRepository workerRepository;
@Autowired
    public WorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllWorkers() {
        System.out.println("getAllWorkers");
        return ResponseEntity.ok(workerRepository.findAll());
    }


}
