package com.namani.demo.repository;

import com.namani.demo.entity.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
    @Query("select d from Device d where d.is_user = ?1")
    List<Device> findByIsUser(int is_user);
}
