package com.namani.demo.dto;

import java.time.LocalDateTime;

public class LocationPostResponseDto {
    public String name; // User name
    public BeaconData beaconData;  // location_x + location_y
    public LocalDateTime last_updated;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(BeaconData beaconData) {
        this.beaconData = beaconData;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.last_updated = lastUpdated;
    }
}
