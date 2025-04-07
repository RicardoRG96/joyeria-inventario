package com.mycompany.joyeriaInventario.exception.jewel;

import com.mycompany.joyeriaInventario.exception.common.ItemNotFoundException;

public class JewelNotFoundException extends ItemNotFoundException {

    public JewelNotFoundException(String message) {
        super(message);
    }

    public JewelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JewelNotFoundException(Throwable cause) {
        super(cause);
    }
    
}
