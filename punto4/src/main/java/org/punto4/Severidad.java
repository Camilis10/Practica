package org.punto4;

public enum Severidad {
    CRITICA(4), ALTA(3), MEDIA(2), BAJA(1);

    private final int prioridad;

    Severidad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
}
