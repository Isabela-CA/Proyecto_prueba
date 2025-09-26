package com.happyfeet.model.enums;

public class SexoMascota {
    // Definir el enum
    public enum Sexo {
        MACHO, HEMBRA, INDEFINIDO;

        public static Sexo fromString(String value) {
            if (value == null) return null;
            try {
                return Sexo.valueOf(value.toUpperCase());
            } catch (IllegalArgumentException e) {
                return INDEFINIDO; // o manejar el error como prefieras
            }
        }

        public static Sexo fromInt(int value) {
            switch (value) {
                case 1:
                    return MACHO;
                case 2:
                    return HEMBRA;
                default:
                    return INDEFINIDO;
            }
        }
    }
}

