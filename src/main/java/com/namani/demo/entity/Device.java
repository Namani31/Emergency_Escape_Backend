package com.namani.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public String name;
    private int is_user;
    private float location_x;
    private float location_y;
    private int floor;
    private LocalDateTime last_updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsUser() {
        return is_user;
    }

    public void setIsUser(int is_user) {
        this.is_user = is_user;
    }

    public float getLocationX() {
        return location_x;
    }

    public void setLocationX(float locationX) {
        this.location_x = locationX;
    }

    public float getLocationY() {
        return location_y;
    }

    public void setLocationY(float locationY) {
        this.location_y = locationY;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public LocalDateTime getLastUpdated() {
        return last_updated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.last_updated = lastUpdated;
    }
}
