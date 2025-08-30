package org.punto8;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reunion implements Comparable<Reunion> {
    private LocalDateTime fechaHora;
    private String asunto;

    public Reunion(LocalDateTime fechaHora, String asunto) {
        this.fechaHora = fechaHora;
        this.asunto = asunto;
    }

    @Override
    public int compareTo(Reunion otra) {
        return this.fechaHora.compareTo(otra.fechaHora);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reunion reunion = (Reunion) obj;
        return Objects.equals(fechaHora, reunion.fechaHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHora);
    }

    @Override
    public String toString() {
        return fechaHora + " - " + asunto;
    }

    // Getters
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getAsunto() { return asunto; }
}
