package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class ProjectState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
