package com.namani.ee.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Beacon Data Request DTO")
public class BeaconData {

    @Schema(description = "Beacon Name", example = "Beacon_1")
    String name;
    @Schema(description = "Beacon UUID", example = "1f4ae6a0-0037-4020-4101-271071580001")
    UUID uuid;
    @Schema(description = "Beacon Major", example = "225")
    int major;
    @Schema(description = "Beacon Minor", example = "925")
    int minor;

    public UUID getUuid() {
        return uuid;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }
}
