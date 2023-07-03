package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class ProjectExpense {
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
    @JoinColumn(name = "operation")
    private ProjectOperation operation;

    @ManyToOne
    @JoinColumn(name = "type")
    private ExpenseType type;

    private float value;
}
