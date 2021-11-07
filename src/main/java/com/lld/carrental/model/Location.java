package com.lld.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@ToString
@Getter
public class Location {

    private double x;
    private double y;

    public Double getDistance(Location location){
        return Math.sqrt((Math.pow((this.x - location.x),2) + Math.pow((this.y-location.y),2)));
    }
}
