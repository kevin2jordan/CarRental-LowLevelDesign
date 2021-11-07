package com.lld.carrental.exceptions;

import lombok.NonNull;

public class TripNotFoundException extends RuntimeException{

    public TripNotFoundException(@NonNull final String message) {
        super(message);
    }
}
