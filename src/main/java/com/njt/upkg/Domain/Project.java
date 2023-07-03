package com.njt.upkg.Domain;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date deadline;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private Buyer buyer;

    private float value;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "state")
    private ProjectState state;

    public Project() {
    }

    public Project(String name, Date deadline, Buyer buyer, float value, User createdBy, ProjectState state) {
        this.name = name;
        this.deadline = deadline;
        this.buyer = buyer;
        this.value = value;
        this.createdBy = createdBy;
        this.state = state;
    }

    public Project(int id, String name, Date deadline, Buyer buyer, float value, User createdBy, ProjectState state) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.buyer = buyer;
        this.value = value;
        this.createdBy = createdBy;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public ProjectState getState() {
        return state;
    }

    public void setState(ProjectState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                ", buyer=" + buyer +
                ", value=" + value +
                ", createdBy=" + createdBy +
                ", state=" + state +
                '}';
    }
}
