package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class WorkerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
