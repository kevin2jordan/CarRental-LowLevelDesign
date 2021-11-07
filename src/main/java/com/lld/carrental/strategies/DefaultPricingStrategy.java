package com.lld.carrental.strategies;

import com.lld.carrental.model.Location;
import org.springframework.stereotype.Component;

@Component
public class DefaultPricingStrategy implements PricingStrategy{

    public static final Double PER_KM_RATE = 10.0;
    @Override
    public Double getPrice(Location fromLocation, Location toLocation) {
        return fromLocation.getDistance(toLocation)*PER_KM_RATE;
    }
}
