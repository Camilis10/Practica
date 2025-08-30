package org.punto4;
import java.time.LocalDateTime;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private String descripcion;
    private Severidad severidad;
    private LocalDateTime fechaCreacion;

    public Ticket(int id, String descripcion, Severidad severidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.fechaCreacion = LocalDateTime.now();
    }

    // Constructor con fecha específica (para testing)
    public Ticket(int id, String descripcion, Severidad severidad, LocalDateTime fechaCreacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public Severidad getSeveridad() { return severidad; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    @Override
    public int compareTo(Ticket otro) {
        // Primero comparar por severidad (mayor prioridad primero)
        int comparacionSeveridad = Integer.compare(
                otro.severidad.getPrioridad(),
                this.severidad.getPrioridad()
        );

        // Si la severidad es igual, comparar por fecha más antigua
        if (comparacionSeveridad == 0) {
            return this.fechaCreacion.compareTo(otro.fechaCreacion);
        }

        return comparacionSeveridad;
    }

    @Override
    public String toString() {
        return String.format("Ticket #%d [%s] - %s - Creado: %s",
                id, severidad, descripcion, fechaCreacion);
    }
}