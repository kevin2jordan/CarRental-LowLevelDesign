package com.lld.carrental.managers;

import com.lld.carrental.exceptions.CabAlreadyExistsException;
import com.lld.carrental.exceptions.CabNotFoundException;
import com.lld.carrental.model.Cab;
import com.lld.carrental.model.Location;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class CabsManager {

    Map<String, Cab> cabs = new HashMap<>();

    public void createCab(@NonNull final Cab cab) {
        if(cabs.containsKey(cab.getId())) {
            throw new CabAlreadyExistsException("Cab already exist");
        }

        cabs.put(cab.getId(), cab);
    }

    public Cab getCabById(@NonNull final String cabId) {
        if(!cabs.containsKey(cabId)) {
            throw new CabNotFoundException("Cab not found exception");
        }

        return cabs.get(cabId);
    }

    public void updateCabLocation(@NonNull final String cabId, @NonNull final Location location) {
        if(!cabs.containsKey(cabId)) {
            throw new CabNotFoundException("Cab not found exception");
        }
        cabs.get(cabId).setCurrLocation(location);
    }

    public void updateCabAvailiabilityStatus(@NonNull final String cabId, @NonNull final boolean status) {
        if(!cabs.containsKey(cabId)) {
            throw new CabNotFoundException("Cab not found exception");
        }
        cabs.get(cabId).setAvailiable(status);
    }

    public List<Cab> getAllNearByCabsWithinGivenDistance(@NonNull Location location, @NonNull final Double distance) {
        List<Cab> allAvailaibleNearByCabs = new LinkedList<>();
        for(Cab cab : cabs.values()) {
            if(cab.isAvailiable() && cab.getCurrLocation().getDistance(location) <= distance) {
                allAvailaibleNearByCabs.add(cab);
            }
        }
        return allAvailaibleNearByCabs;
    }
}
