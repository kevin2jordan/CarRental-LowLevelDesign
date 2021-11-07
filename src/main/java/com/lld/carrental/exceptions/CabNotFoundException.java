package com.lld.carrental.exceptions;

import lombok.NonNull;

public class CabNotFoundException extends  RuntimeException{

    public CabNotFoundException(@NonNull final String message) {
        super(message);
    }
}
