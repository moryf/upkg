package com.njt.upkg.Domain;
import jakarta.persistence.*;
@Entity
public class MeasuringUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public MeasuringUnit() {
    }

    public MeasuringUnit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MeasuringUnit(String name) {
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
        return "MeasuringUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
