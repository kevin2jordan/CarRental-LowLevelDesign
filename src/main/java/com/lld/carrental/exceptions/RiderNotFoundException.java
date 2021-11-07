package com.lld.carrental.exceptions;

import lombok.NonNull;

public class RiderNotFoundException extends RuntimeException{

    public RiderNotFoundException(@NonNull final String message) {
        super(message);
    }
}
