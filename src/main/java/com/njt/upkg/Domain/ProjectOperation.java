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

    @Enumerated(EnumType.STRING)
    private ProjectState state;

    @ManyToOne
    @JoinColumn(name = "worker")
    private Worker worker;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp start;

    private Timestamp plannedEnd;
    private Timestamp ended;
    private boolean active;

    public ProjectOperation() {
    }

    public ProjectOperation(int id, Project project, Position position, ProjectState state, Worker worker, OperationType type, Timestamp start, Timestamp plannedEnd, Timestamp ended, boolean active) {
        this.id = id;
        this.project = project;
        this.position = position;
        this.state = state;
        this.worker = worker;
        this.type = type;
        this.start = start;
        this.plannedEnd = plannedEnd;
        this.ended = ended;
        this.active = active;
    }

    public ProjectOperation(Project project, Position position, ProjectState state, Worker worker, OperationType type, Timestamp start, Timestamp plannedEnd, Timestamp ended, boolean active) {
        this.project = project;
        this.position = position;
        this.state = state;
        this.worker = worker;
        this.type = type;
        this.start = start;
        this.plannedEnd = plannedEnd;
        this.ended = ended;
        this.active = active;
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

    public ProjectState getState() {
        return state;
    }

    public void setState(ProjectState state) {
        this.state = state;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(Timestamp plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public Timestamp getEnded() {
        return ended;
    }

    public void setEnded(Timestamp ended) {
        this.ended = ended;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProjectOperation{" +
                "id=" + id +
                ", project=" + project +
                ", position=" + position +
                ", state=" + state +
                ", worker=" + worker +
                ", type=" + type +
                ", start=" + start +
                ", plannedEnd=" + plannedEnd +
                ", ended=" + ended +
                ", active=" + active +
                '}';
    }
}
