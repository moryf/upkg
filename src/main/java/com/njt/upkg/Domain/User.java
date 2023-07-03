package com.njt.upkg.Domain;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
