package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class OperationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
