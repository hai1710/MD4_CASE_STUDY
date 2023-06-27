package com.demo.repository;

import com.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location,Long> {
    List<Location> findAllByNameContainingIgnoreCase(String name);

}
