package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class WorkerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public WorkerType() {
    }

    public WorkerType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public WorkerType(String name) {
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
        return "WorkerType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
