package com.mycompany.joyeriaInventario.exception.saleItem;

import com.mycompany.joyeriaInventario.exception.common.ItemNotFoundException;

public class SaleItemNotFoundException extends ItemNotFoundException {

    public SaleItemNotFoundException(String message) {
        super(message);
    }

    public SaleItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaleItemNotFoundException(Throwable cause) {
        super(cause);
    }
   
}
