package com.njt.upkg.controllers;

import com.njt.upkg.domain.Buyer;
import com.njt.upkg.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buyer")
@CrossOrigin
public class BuyerController {

    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerController(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBuyers() {
        return ResponseEntity.ok(buyerRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBuyer(@RequestBody Buyer buyer) {
        return ResponseEntity.ok(buyerRepository.save(buyer));
    }
}