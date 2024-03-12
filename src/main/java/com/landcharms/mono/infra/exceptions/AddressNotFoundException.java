package com.landcharms.mono.infra.exceptions;

import java.util.Map;

public class AddressNotFoundException extends NotFoundException {

    public AddressNotFoundException(String message) {
        super(message);
    }

}