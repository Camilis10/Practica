package org.punto2;
import java.util.LinkedList;
public class Estudiante {

    private String nombre;
    private boolean tieneReserva;

    public Estudiante(String nombre, boolean tieneReserva) {
        this.nombre = nombre;
        this.tieneReserva = tieneReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneReserva() {
        return tieneReserva;
    }

    @Override
    public String toString() {
        return nombre + (tieneReserva ? " (Reservado)" : "");
    }

}
