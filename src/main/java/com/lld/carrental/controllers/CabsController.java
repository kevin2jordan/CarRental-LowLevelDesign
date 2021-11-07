package com.lld.carrental.controllers;

import com.lld.carrental.managers.CabsManager;
import com.lld.carrental.managers.TripsManager;
import com.lld.carrental.model.Cab;
import com.lld.carrental.model.Location;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CabsController {

    @Autowired
    private CabsManager cabsManager;

    @Autowired
    private TripsManager tripsManager;

    @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
    public ResponseEntity<String> regiserCab( final String cabId, final String driverName) {
        cabsManager.createCab(new Cab(cabId, driverName));
        return ResponseEntity.ok("Cab registered successfully");
    }

    @RequestMapping(value = "/update/cab/location", method = RequestMethod.POST)
    public ResponseEntity<String> updateCabLocation(final String cabId,  final double newX, final double newY) {

        cabsManager.updateCabLocation(cabId, new Location(newX, newY));
        return ResponseEntity.ok("Cab location updated successfully");
    }

    @RequestMapping(value = "/update/cab/availability", method = RequestMethod.POST)
    public ResponseEntity<String> updateCabAvailability(final String cabId, final boolean newAvailability) {
        cabsManager.updateCabAvailiabilityStatus(cabId, newAvailability);
        return ResponseEntity.ok("Cab availiablity status updated successfully");
    }

    @RequestMapping(value = "/update/cab/end/trip", method = RequestMethod.POST)
    public ResponseEntity<String> endTrip(final String cabId) {
        tripsManager.endTrip(cabsManager.getCabById(cabId));
        return ResponseEntity.ok("Trip ended successfully");
    }

    @RequestMapping(value="/getCabById")
    public Cab getCabById(final String id) {
        return cabsManager.getCabById(id);
    }
}
