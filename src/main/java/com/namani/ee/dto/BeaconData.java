package com.namani.ee.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Beacon Data Request DTO")
public class BeaconData {

    @Schema(description = "Beacon Name", example = "Beacon_1")
    String name;
//    @Schema(description = "Distance between beacons", example = "30.12cm")
//    double distance;
    @Schema(description = "Phone UUID", example = "efbbbf30-3639-3339-3431-300000000000")
    UUID uuid;
    public UUID getUuid() {
        return uuid;
    }
}
