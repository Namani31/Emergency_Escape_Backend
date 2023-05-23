package com.namani.demo.repository;

import com.namani.demo.entity.Device;
import com.namani.demo.entity.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Integer> {

}
