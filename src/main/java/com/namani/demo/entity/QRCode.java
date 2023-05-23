package com.namani.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="qrcode")
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // User identify id
    private String qr_data;
    @Column(name="location_id")
    @ManyToOne
    private Location location;

    private LocalDateTime last_updated;

    private int captured_count;

    public void setLast_updated(LocalDateTime last_updated) {
        this.last_updated = last_updated;
    }

    public Location getLocation() {
        return location;
    }
}
