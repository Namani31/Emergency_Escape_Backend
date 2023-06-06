package com.namani.ee.controller.location;

import com.namani.ee.dto.LocationPostRequestDto;
import com.namani.ee.entity.Device;
import com.namani.ee.entity.Location;
import com.namani.ee.entity.QRCode;
import com.namani.ee.repository.DeviceRepository;
import com.namani.ee.repository.QRCodeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    public LocationController(DeviceRepository deviceRepository, QRCodeRepository qrCodeRepository) {
        this.deviceRepository = deviceRepository;
        this.qrCodeRepository = qrCodeRepository;
    }

    @Operation(summary = "QR, Beacon POST", description = "QR, Beacon POST")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
    })

    // 내가 위치정보 받기
    @PostMapping("/test/api/v1/location")
    public String postLocation(@RequestBody LocationPostRequestDto locationPostRequestDto) {

        QRCode qrcode = qrCodeRepository.findByQRData(locationPostRequestDto.getQrData());  // DB에서 QR데이터 일치하는 엔티티 가져오기
        Device major = deviceRepository.findByMajor(locationPostRequestDto.getBeaconData().getMajor());
        Device minor = deviceRepository.findByMinor(locationPostRequestDto.getBeaconData().getMinor());

        if (qrcode == null) {
            Device device = deviceRepository.findByUuid(locationPostRequestDto.getBeaconData().getUuid()); // 비콘 데이터, UUID를 DB에서 확인

            if (device == null) {   // QR, 비콘데이터 둘 다 일치하는게 없으면 실패
                return "실패";
            }
            device.setLast_updated(LocalDateTime.now());
            deviceRepository.save(device);
            return "성공";
        }
        qrcode.setCaptured_count(qrcode.getCaptured_count()+1);
        qrcode.setLast_updated(LocalDateTime.now());
        qrCodeRepository.save(qrcode);
        return "성공";
    }

    @Operation(summary = "QR, Beacon GET", description = "QR, Beacon GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
    })
    // 위치정보 주기
    @GetMapping("/test/api/v1/location")
    public List<Location> getLocation() {

        LocalDateTime start = LocalDateTime.now().minusHours(2);
        LocalDateTime end = LocalDateTime.now();
        List<QRCode> listQRCode = qrCodeRepository.findAllByLastUpdatedBetween(start, end);
        List<Device> listDevice = deviceRepository.findAllByLastUpdatedBetween(start, end);
        List<Location> listLocation = new ArrayList<Location>();

        for (int qrGet = 0; qrGet < listQRCode.size(); qrGet++) {
            QRCode qrCode = listQRCode.get(qrGet);
            qrCode.setLast_updated(LocalDateTime.of(1970, 1, 1, 0,0,1));    // DB에 최소값 기록
            qrCodeRepository.save(qrCode);
            listLocation.add(qrCode.getLocation());
        }

        for (int deviceGet = 0; deviceGet < listDevice.size(); deviceGet++) {
            Device device = listDevice.get(deviceGet);
            device.setLast_updated(LocalDateTime.of(1970, 1, 1, 0,0,1));    // DB에 최소값 기록
            deviceRepository.save(device);
            listLocation.add(device.getLocation());
        }
        return listLocation;
    }

}
