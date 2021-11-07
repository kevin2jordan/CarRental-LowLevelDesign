package com.lld.carrental.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
public class Trip {

    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private Location toPoint;
    private Location fromPoint;

    public void endTrip() {
        this.tripStatus = TripStatus.FINISHED;
    }

}
