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

    public ProjectExpense() {
    }

    public ProjectExpense(int id, Project project, Position position, ProjectOperation operation, ExpenseType type, float value) {
        this.id = id;
        this.project = project;
        this.position = position;
        this.operation = operation;
        this.type = type;
        this.value = value;
    }

    public ProjectExpense(Project project, Position position, ProjectOperation operation, ExpenseType type, float value) {
        this.project = project;
        this.position = position;
        this.operation = operation;
        this.type = type;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ProjectOperation getOperation() {
        return operation;
    }

    public void setOperation(ProjectOperation operation) {
        this.operation = operation;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProjectExpense{" +
                "id=" + id +
                ", project=" + project +
                ", position=" + position +
                ", operation=" + operation +
                ", type=" + type +
                ", value=" + value +
                '}';
    }
}
