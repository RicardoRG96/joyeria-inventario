package com.mycompany.joyeriaInventario.model.vo;

import java.util.Objects;

public class NameVO {

    private String name;
    
    public NameVO(String name) throws IllegalArgumentException {
        validate(name);
        this.name = name.trim();
    }
    
    private void validate(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        if (name.length() < 2 || name.length() > 100) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 100 caracteres.");
        }
        if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NameVO other = (NameVO) obj;
        return name == other.name;
    }
    
}
