package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class OperationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public OperationType() {
    }

    public OperationType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public OperationType(String name) {
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
        return "OperationType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
