package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

    private String name;
    private boolean readyToMount;
    private boolean mounted;

}
