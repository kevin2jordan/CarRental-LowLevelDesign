package com.lld.carrental.controllers;

import com.lld.carrental.managers.RidersManager;
import com.lld.carrental.managers.TripsManager;
import com.lld.carrental.model.Location;
import com.lld.carrental.model.Rider;
import com.lld.carrental.model.Trip;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RidersController {

    @Autowired
    private RidersManager ridersManager;

    @Autowired
    private TripsManager tripsManager;


    @RequestMapping(value="/register/rider", method = RequestMethod.POST)
    public ResponseEntity<String> registerRider(final String riderId, final String riderName) {

        ridersManager.createRider(new Rider(riderId, riderName));

        return ResponseEntity.ok("Rider created successfully");
    }

    @RequestMapping(value = "/bookRide", method = RequestMethod.POST)
    public ResponseEntity<String> bookCab(final String riderId, final double srcX, final double srcY,
             final double destX, final double destY) {

        tripsManager.createTrip(ridersManager.getRiderById(riderId),
                new Location(srcX, srcY),
                new Location(destX, destY));
        return ResponseEntity.ok("Ride created successfully");
    }

    @RequestMapping(value = "/fetchTripHistory")
    public List<Trip> fetchTripHistory(final String riderId) {
        return tripsManager.getTripHistory(ridersManager.getRiderById(riderId));
    }

}
