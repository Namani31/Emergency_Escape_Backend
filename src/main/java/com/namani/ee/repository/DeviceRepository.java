package com.namani.ee.repository;

import com.namani.ee.entity.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
    public Device findByUuid(UUID uuid);
    @Query("select d from Device d where d.last_updated between ?1 and ?2")
    public List<Device> findAllByLastUpdatedBetween(LocalDateTime start, LocalDateTime end);
}
