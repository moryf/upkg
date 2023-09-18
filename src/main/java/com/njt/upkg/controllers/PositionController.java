package com.njt.upkg.controllers;

import com.njt.upkg.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/position")
public class PositionController {
    PositionRepository positionRepository;

    @Autowired
    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {

        positionRepository.deleteById(id);
    }

}
