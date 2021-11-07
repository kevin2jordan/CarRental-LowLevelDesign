package com.lld.carrental.strategies;

import com.lld.carrental.model.Cab;
import com.lld.carrental.model.Location;
import com.lld.carrental.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {

    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromLocation, Location toLocation);
}
