package com.lld.carrental.managers;

import com.lld.carrental.exceptions.TripNotFoundException;
import com.lld.carrental.model.*;
import com.lld.carrental.strategies.CabMatchingStrategy;
import com.lld.carrental.strategies.PricingStrategy;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class TripsManager {

    private static final Double MAX_ALLOWED_DISTANCE = 10.0;
    Map<String, List<Trip>> trips = new HashMap<>();

    @Autowired
    private CabsManager cabsManager;
    @Autowired
    private RidersManager ridersManager;
    @Autowired
    private PricingStrategy pricingStrategy;
    @Autowired
    private CabMatchingStrategy cabMatchingStrategy;


    public void createTrip(@NonNull Rider rider, @NonNull Location fromLocation, @NonNull Location toLocation) {

        final List<Cab> allNearByCabsWithinGivenDistance = cabsManager.getAllNearByCabsWithinGivenDistance(fromLocation, MAX_ALLOWED_DISTANCE);

        final List<Cab> allPotentialCabs = allNearByCabsWithinGivenDistance.stream()
                .filter(cab -> Objects.nonNull(cab.getCurrentTrip()))
                .collect(Collectors.toList());

        final Cab cab = cabMatchingStrategy.matchCabToRider(rider, allPotentialCabs, fromLocation, toLocation);
        final Double price = pricingStrategy.getPrice(fromLocation, toLocation);
        final Trip trip = new Trip(rider, cab, TripStatus.IN_PROGRESS, price, fromLocation, toLocation);

        if(!trips.containsKey(rider.getId())){
            trips.put(rider.getId(), new LinkedList<>());
        }
        trips.get(rider.getId()).add(trip);
        cab.setCurrentTrip(trip);
    }

    public List<Trip> getTripHistory(@NonNull final Rider rider) {
        return trips.get(rider.getId());
    }

    public void endTrip(@NonNull final Cab cab) {
        if(cab.getCurrentTrip() == null) {
            throw new TripNotFoundException("Trip not found exception");
        }
        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
