package com.namani.demo.controller.location;

import com.namani.demo.dto.LocationPostRequestDto;
import com.namani.demo.entity.Device;
import com.namani.demo.entity.Location;
import com.namani.demo.entity.QRCode;
import com.namani.demo.repository.DeviceRepository;
import com.namani.demo.repository.QRCodeRepository;
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
    private QRCodeRepository qrCodeRepository;

    public LocationController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    // 내가 위치정보 받기
    @PostMapping("/test/api/v1/location")
    public String postLocation(@RequestBody LocationPostRequestDto locationPostRequestDto) {
        QRCode qrcode = qrCodeRepository.findByQRData(locationPostRequestDto.getQrData());  // DB에서 QR데이터 일치하는 엔티티 가져오기

        if (qrcode == null) {
            Device device = deviceRepository.findByUuid(locationPostRequestDto.getBeaconData().getUuid()); // 비콘 데이터, UUID를 DB에서 확인
            if (device == null) {   // QR, 비콘데이터 둘 다 일치하는게 없으면 실패
                return "실패";
            }
            device.setLast_updated(LocalDateTime.now());
            return "성공";
        }
        qrcode.setLast_updated(LocalDateTime.now());
        return "성공";
    }

    // 위치정보 주기
    @GetMapping("/test/api/v1/location")
    public List<Location> getLocation() {
        LocalDateTime start = LocalDateTime.now().minusHours(2);
        LocalDateTime end = LocalDateTime.now();
        List<QRCode> listQRCode = qrCodeRepository.findAllByLastUpdatedBetween(start, end);
        List<Device> listDevice = deviceRepository.findAllByLastUpdatedBetween(start, end);
        List<Location> listLocation = new ArrayList<Location>();

        for (int i = 0; i < listQRCode.size(); i++) {
            listLocation.add(listQRCode.get(i).getLocation());

        }

        for (int i = 0; i < listDevice.size(); i++) {
            listLocation.add(listDevice.get(i).getLocation());
        }
        return listLocation;
    }
}
