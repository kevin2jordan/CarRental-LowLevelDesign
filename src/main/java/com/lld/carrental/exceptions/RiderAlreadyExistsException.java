package com.lld.carrental.exceptions;

import lombok.NonNull;

public class RiderAlreadyExistsException extends RuntimeException{

    public RiderAlreadyExistsException(@NonNull final String message) {
        super(message);
    }
}
