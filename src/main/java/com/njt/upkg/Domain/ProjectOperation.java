package com.njt.upkg.Domain;
import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
public class ProjectOperation {
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
    @JoinColumn(name = "state")
    private ProjectState state;

    @ManyToOne
    @JoinColumn(name = "worker")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "type")
    private OperationType type;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp start;

    private Timestamp plannedEnd;
    private Timestamp ended;
    private boolean active;
}
