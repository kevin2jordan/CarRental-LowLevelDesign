package com.lld.carrental.strategies;

import com.lld.carrental.model.Cab;
import com.lld.carrental.model.Location;
import com.lld.carrental.model.Rider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultCabMatchingStrategy implements CabMatchingStrategy {

    @Override
    public Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromLocation, Location toLocation) {
        if(candidateCabs.isEmpty()) {
            return null;
        }
        return candidateCabs.get(0);
    }
}
