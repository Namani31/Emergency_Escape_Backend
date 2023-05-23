package com.namani.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationPostRequestDto {
    int id;
    @JsonProperty("location")
    Location location;

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
