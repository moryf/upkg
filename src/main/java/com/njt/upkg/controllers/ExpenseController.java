package com.njt.upkg.controllers;

import com.njt.upkg.repository.ProjectExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/expense")
public class ExpenseController {
    ProjectExpenseRepository projectExpenseRepository;

    @Autowired
    public ExpenseController(ProjectExpenseRepository projectExpenseRepository) {
        this.projectExpenseRepository = projectExpenseRepository;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        projectExpenseRepository.deleteById(id);
    }

}
