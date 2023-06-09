package com.namani.ee.entity;

import jakarta.persistence.*;

@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // User identify id
    public int room_number;
    public int floor;
}
