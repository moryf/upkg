package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
}
