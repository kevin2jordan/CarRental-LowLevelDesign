package com.lld.carrental.strategies;

import com.lld.carrental.model.Location;

public interface PricingStrategy {

    Double getPrice(Location fromLocation, Location toLocation);
}
