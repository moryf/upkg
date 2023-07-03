package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class ProjectState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public ProjectState(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProjectState() {
    }

    public ProjectState(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "ProjectState{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
