package com.namani.demo.controller.location;

import com.namani.demo.dto.LocationPostRequestDto;
import com.namani.demo.entity.Device;
import com.namani.demo.repository.DeviceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class LocationController {

    private DeviceRepository deviceRepository;

    public LocationController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    // 내가 위치정보 받기
    @PostMapping("/test/api/v1/location")
    public String postLocation(LocationPostRequestDto locationPostRequestDto) {
        Device device = new Device();
        device.setId(locationPostRequestDto.getId());
        device.setLocationX(locationPostRequestDto.getLocation().getX());
        device.setLocationY(locationPostRequestDto.getLocation().getY());
        device.setFloor(locationPostRequestDto.getLocation().getFloor());
        device.setName("testName");
        device.setIsUser(1);
        device.setLastUpdated(LocalDateTime.now());
        deviceRepository.save(device);
        return "Success!";
    }

    // 위치정보 주기
    @GetMapping("/test/api/v1/location")
    public String getLocation() {

        return "";
    }
}
