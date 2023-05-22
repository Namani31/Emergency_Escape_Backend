package com.namani.demo.repository;

import com.namani.demo.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Integer> {

}
