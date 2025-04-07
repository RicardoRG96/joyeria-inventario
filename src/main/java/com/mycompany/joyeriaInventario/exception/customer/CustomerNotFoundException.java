package com.mycompany.joyeriaInventario.exception.customer;

import com.mycompany.joyeriaInventario.exception.common.ItemNotFoundException;

public class CustomerNotFoundException extends ItemNotFoundException {

    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }
    
}
