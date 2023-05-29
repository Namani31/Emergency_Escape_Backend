package com.namani.demo.repository;

import com.namani.demo.entity.Device;
import com.namani.demo.entity.QRCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface QRCodeRepository extends CrudRepository<QRCode, Integer> {
    @Query("select d from QRCode d where d.qr_data = ?1")
    public QRCode findByQRData(String QRdata);
    @Query("select d from QRCode d where d.last_updated between ?1 and ?2")
    public List<QRCode> findAllByLastUpdatedBetween(LocalDateTime start, LocalDateTime end);
}
