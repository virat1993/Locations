package com.general.Locations.controller;

import com.general.Locations.dto.location.RequestDto;
import com.general.Locations.dto.location.UpdateDto;
import com.general.Locations.entity.LocationEntity;
import org.locationtech.jts.geom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.general.Locations.repository.LocationRepoistory;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    LocationRepoistory locationRepoistory;


    @GetMapping(path= "/getAll")
    public List<LocationEntity> getLocationDetails(){
        return locationRepoistory.findAll();
    }

    @PostMapping(path = "/addDetails")
    public ResponseEntity addDetails(@RequestBody RequestDto requestDto){
        LocationEntity entity = new LocationEntity();
        entity.setLatitude(requestDto.getLatitude());
        entity.setLongitude(requestDto.getLongitude());
        //longitude is X on a plane
        //latitude is Y on a plane
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 26910);
        entity.setGeometricLocation(
                geometryFactory.createPoint(
                        new Coordinate(requestDto.getLatitude(), requestDto.getLongitude())
                ));
        locationRepoistory.save(entity);
        return ResponseEntity.ok("added data with Id" + entity.getLocationId());
    }

    @PatchMapping(path = "/updateLocationById")
    public ResponseEntity updateLocationDetails(@RequestBody UpdateDto requestDto) throws Exception {
        LocationEntity entity = locationRepoistory.findById(requestDto.getLocationId())
                .orElseThrow(() ->new Exception("Could not find the id"));

        entity.setLatitude(requestDto.getLatitude());
        entity.setLongitude(requestDto.getLongitude());
        //longitude is X on a plane
        //latitude is Y on a plane
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 26910);
        entity.setGeometricLocation(
                geometryFactory.createPoint(
                        new Coordinate(requestDto.getLatitude(), requestDto.getLongitude())
                ));
        locationRepoistory.save(entity);
        return ResponseEntity.ok("updated record " + entity.getLocationId());
    }
    @DeleteMapping(path = "/deleteLocationById/{id}")
    public ResponseEntity deleteLocationById(@PathVariable int id) throws Exception {
        LocationEntity entity = locationRepoistory.findById(id)
                .orElseThrow(() ->new Exception("Could not find the id"));
        locationRepoistory.delete(entity);
        return ResponseEntity.ok().body("delete successfully");

    }
}
