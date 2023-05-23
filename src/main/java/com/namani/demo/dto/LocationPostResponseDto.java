package com.namani.demo.dto;

import java.time.LocalDateTime;

public class LocationPostResponseDto {
    public String name; // User name
    public Location location;  // location_x + location_y
    public LocalDateTime last_updated;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.last_updated = lastUpdated;
    }
}
