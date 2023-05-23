package com.namani.demo.controller.location;

import com.namani.demo.dto.Location;
import com.namani.demo.dto.LocationPostRequestDto;
import com.namani.demo.dto.LocationPostResponseDto;
import com.namani.demo.entity.Device;
import com.namani.demo.repository.DeviceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationController {

    private DeviceRepository deviceRepository;

    public LocationController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    // 내가 위치정보 받기
    @PostMapping("/test/api/v1/location")
    public String postLocation(@RequestBody LocationPostRequestDto locationPostRequestDto) {
        Device device = new Device();
        device.setId(locationPostRequestDto.getId());
        device.setLocationX(locationPostRequestDto.getLocation().getX());
        device.setLocationY(locationPostRequestDto.getLocation().getY());
        device.setFloor(locationPostRequestDto.getLocation().getFloor());
        device.setName("testName");
        device.setIsUser(1);
        device.setLastUpdated(LocalDateTime.now());
        deviceRepository.save(device);
        return String.valueOf(locationPostRequestDto.getId());
    }

    // 위치정보 주기
    @GetMapping("/test/api/v1/location")
    public List<LocationPostResponseDto> getLocation() {
        List<Device> listDevice = deviceRepository.findByIsUser(1); // DB에서 숫자가 1인 유저를 찾아와라
        ArrayList<LocationPostResponseDto> listLocation = new ArrayList<LocationPostResponseDto>(listDevice.size());
        for (int i = 0; i < listDevice.size(); i++) {
            LocationPostResponseDto locationPostResponseDto = new LocationPostResponseDto();
            locationPostResponseDto.setName(listDevice.get(i).name);
            Location location = new Location();
            location.setX(listDevice.get(i).getLocationX());
            location.setY(listDevice.get(i).getLocationY());
            location.setFloor(listDevice.get(i).getFloor());
            locationPostResponseDto.setLocation(location);
            locationPostResponseDto.setLastUpdated(listDevice.get(i).getLastUpdated());
            listLocation.add(locationPostResponseDto);
        }
        return listLocation;
    }
}
