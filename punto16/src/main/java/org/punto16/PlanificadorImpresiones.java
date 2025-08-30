package org.punto16;

import java.util.PriorityQueue;
import java.util.Queue;

public class PlanificadorImpresiones {
    private Queue<Trabajo> colaPrioridad;

    public PlanificadorImpresiones() {
        colaPrioridad = new PriorityQueue<>();
    }

    public void agregarTrabajo(Trabajo trabajo) {
        colaPrioridad.offer(trabajo);
        System.out.println("✓ Agregado: " + trabajo);
    }

    public Trabajo procesarSiguiente() {
        return colaPrioridad.poll();
    }

    public boolean hayTrabajosPendientes() {
        return !colaPrioridad.isEmpty();
    }

    public int getCantidadTrabajos() {
        return colaPrioridad.size();
    }
}
