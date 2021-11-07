package com.lld.carrental.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class Cab {

    private final String id;
    private final String driverName;

    @Setter
    private Location currLocation;
    @Setter
    private Trip currentTrip;
    @Setter
    private boolean isAvailiable;

    public Cab(final String id, final String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailiable = true;
    }


}
