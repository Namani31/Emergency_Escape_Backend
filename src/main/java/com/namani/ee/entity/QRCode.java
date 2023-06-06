package com.namani.ee.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="qrcode")
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // User identify id
    private String qr_data;
    @JoinColumn(name="location_id")
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

    public void setCaptured_count(int captured_count) {
        this.captured_count = captured_count;
    }

    public int getCaptured_count() {
        return captured_count;
    }
}
