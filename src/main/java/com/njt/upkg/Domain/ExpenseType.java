package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class ExpenseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public ExpenseType() {
    }

    public ExpenseType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ExpenseType(String name) {
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
        return "ExpenseType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
