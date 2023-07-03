package com.njt.upkg.Domain;
import jakarta.persistence.*;
public class MeasuringUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
