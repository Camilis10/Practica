package org.punto16;

public class Trabajo implements Comparable<Trabajo> {
    private String nombre;
    private int tamaño; // en páginas
    private long timestamp; // momento de creación

    public Trabajo(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.timestamp = System.currentTimeMillis();
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(Trabajo otro) {
        // Primero por tamaño (más pequeño primero)
        if (this.tamaño != otro.tamaño) {
            return Integer.compare(this.tamaño, otro.tamaño);
        }
        // En empate, por antigüedad (más antiguo primero)
        return Long.compare(this.timestamp, otro.timestamp);
    }

    @Override
    public String toString() {
        return nombre + " (" + tamaño + " páginas)";
    }
}