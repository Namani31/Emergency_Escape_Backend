package com.namani.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "QR, Beacon Request DTO")
public class LocationPostRequestDto {

    @Schema(description = "QR Code Room Number, Floor", example = "room_number=1,floor=1")
    String qrData;
    BeaconData beaconData;

    public String getQrData() {
        return qrData;
    }

    public BeaconData getBeaconData() {
        return beaconData;
    }
}
