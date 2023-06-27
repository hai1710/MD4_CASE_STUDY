package com.demo.controller;

import com.demo.model.Location;

import com.demo.service.Location.ILocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("location")
public class LocationController {
    @Autowired
    private ILocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> showAddressList() {
        List<Location> locationList = (List<Location>) locationService.findAll();
        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> findAddressById(@PathVariable Long id) {
        Optional<Location> address = locationService.findById(id);
        if (!address.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address.get(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countLocation(){
        Long count = locationService.count();
        if (count != null){
            return new ResponseEntity<>(count,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Location>> searchLocationByName(@RequestParam("name") String name){
        Iterable<Location> locations = locationService.findByName(name);
        if(locations != null){
        return new ResponseEntity<>(locations,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Location> addNewCompany(@RequestBody Location location) {
        Location newLocation = locationService.save(location);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateAddress(@PathVariable Long id, @RequestBody Location location){
        Optional<Location> addressOptional = locationService.findById(id);
        if (!addressOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        location.setId(addressOptional.get().getId());
        return new ResponseEntity<>(locationService.save(location),HttpStatus.OK);
    }
}
