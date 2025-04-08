package com.mycompany.joyeriaInventario.exception.jewel;

public class InsufficientStockException extends Exception {

    public InsufficientStockException(String message) {
        super(message);
    }

    public InsufficientStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientStockException(Throwable cause) {
        super(cause);
    }
    
}
