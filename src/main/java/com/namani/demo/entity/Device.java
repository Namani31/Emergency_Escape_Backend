package com.namani.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // User identify id
    @Column(columnDefinition = "binary(16)")
    private UUID uuid;
    @Column(name="location_id")
    @ManyToOne
    private Location location;

}
