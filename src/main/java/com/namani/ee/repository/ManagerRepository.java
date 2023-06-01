package com.namani.ee.repository;

import com.namani.ee.entity.Device;
import com.namani.ee.entity.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ManagerRepository extends CrudRepository<Manager, Integer>{
    public Manager findByUsername(String username);
}
