package com.demo.service.Location;

import com.demo.model.Location;
import com.demo.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Iterable<Location> findByName(String name) {
        return locationRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Long count() {
        return locationRepository.count();
    }

    @Override
    public void remove(Long id) {
    locationRepository.deleteById(id);
    }

}
