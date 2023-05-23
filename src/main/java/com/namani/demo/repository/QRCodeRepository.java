package com.namani.demo.repository;

import com.namani.demo.entity.Device;
import com.namani.demo.entity.QRCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface QRCodeRepository extends CrudRepository<QRCode, Integer> {
    public QRCode findByQRData(String QRdata);
    public List<QRCode> findAllByLastUpdatedBetween(LocalDateTime start, LocalDateTime end);
}
