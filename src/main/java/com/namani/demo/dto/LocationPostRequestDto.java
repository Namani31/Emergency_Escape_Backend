package com.namani.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationPostRequestDto {

    String qrData;
    BeaconData beaconData;

    public String getQrData() {
        return qrData;
    }

    public BeaconData getBeaconData() {
        return beaconData;
    }
}
