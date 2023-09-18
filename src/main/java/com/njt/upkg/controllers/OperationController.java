package com.njt.upkg.controllers;


import com.njt.upkg.domain.OperationType;
import com.njt.upkg.repository.ProjectOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operation")
@CrossOrigin
public class OperationController {
    ProjectOperationRepository projectOperationRepository;



    @Autowired
    public OperationController(ProjectOperationRepository projectOperationRepository) {
        this.projectOperationRepository = projectOperationRepository;
    }

    @GetMapping("/types")
    public OperationType[] getOperationTypes() {
        return OperationType.values();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOperation(@PathVariable Long id) {
        projectOperationRepository.deleteById(id);
    }
}
