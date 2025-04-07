package com.mycompany.joyeriaInventario.exception.sale;

import com.mycompany.joyeriaInventario.exception.common.ItemNotFoundException;

public class SaleNotFoundException extends ItemNotFoundException {

    public SaleNotFoundException(String message) {
        super(message);
    }

    public SaleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaleNotFoundException(Throwable cause) {
        super(cause);
    }
    
}
