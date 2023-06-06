package com.namani.ee.entity;

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
    @JoinColumn(name="location_id")
    @ManyToOne
    private Location location;
    private int major;
    private int minor;

    private LocalDateTime last_updated;

    public void setLast_updated(LocalDateTime last_updated) {
        this.last_updated = last_updated;
    }

    public Location getLocation() {
        return location;
    }

}
