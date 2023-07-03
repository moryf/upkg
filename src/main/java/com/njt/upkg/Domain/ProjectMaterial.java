package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class ProjectMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "material")
    private Material material;

    private int amount;
}
