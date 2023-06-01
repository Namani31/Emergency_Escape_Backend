package com.namani.ee.entity;

import jakarta.persistence.*;

@Entity
@Table(name="manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // User identify id
    public String username;
    public String password;
}
