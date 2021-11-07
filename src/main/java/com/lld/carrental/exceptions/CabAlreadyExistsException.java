package com.lld.carrental.exceptions;

import lombok.NonNull;

public class CabAlreadyExistsException extends RuntimeException {

    public CabAlreadyExistsException(@NonNull final String message) {
        super(message);
    }
}
