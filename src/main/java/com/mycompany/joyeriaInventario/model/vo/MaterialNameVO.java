package com.mycompany.joyeriaInventario.model.vo;

import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import java.util.Objects;

public class MaterialNameVO {
    
    private String name;

    public MaterialNameVO(String name) throws InvalidInputException {
        validate(name);
        this.name = name;
    }
    
    private void validate(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("El nombre del cliente no puede estar vacío.");
        }
        if (name.length() < 2 || name.length() > 100) {
            throw new InvalidInputException("El nombre debe tener entre 2 y 100 caracteres.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MaterialNameVO other = (MaterialNameVO) obj;
        return name == other.name;
    }
    
}
