package com.njt.upkg.Domain;

import java.util.Date;
import jakarta.persistence.*;

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

}
