package com.njt.upkg.Domain;
import jakarta.persistence.*;


@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "type")
    private WorkerType type;

    private float pricePerHour;
}
