package com.namani.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Beacon Data Request DTO")
public class BeaconData {

    @Schema(description = "Beacon Name", example = "Beacon_1")
    String name;
    @Schema(description = "Distance between beacons", example = "30.12cm")
    double distance;
    @Schema(description = "Phone UUID", example = "12345678-1234-5678-1234-567812345678")
    UUID uuid;
    public UUID getUuid() {
        return uuid;
    }
}
