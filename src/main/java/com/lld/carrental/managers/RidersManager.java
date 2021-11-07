package com.lld.carrental.managers;

import com.lld.carrental.exceptions.RiderAlreadyExistsException;
import com.lld.carrental.exceptions.RiderNotFoundException;
import com.lld.carrental.model.Rider;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RidersManager {

    Map<String, Rider> riders = new HashMap<>();

    public void createRider(@NonNull final Rider rider) {
        if(riders.containsKey(rider.getId())) {
            throw new RiderAlreadyExistsException("Rider already exists");
        }
        riders.put(rider.getId(), rider);
    }

    public Rider getRiderById(@NonNull final String riderId) {
        if(!riders.containsKey(riderId)) {
            throw new RiderNotFoundException("Rider not found");
        }
       return riders.get(riderId);
    }
}
