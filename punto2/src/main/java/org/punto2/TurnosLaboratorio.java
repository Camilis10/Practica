package org.punto2;

import java.util.LinkedList;

public class TurnosLaboratorio {
    private LinkedList<Estudiante> colaIngreso;;

    public TurnosLaboratorio() {
        colaIngreso = new LinkedList<>();
    }

    public void agregarEstudiante(String nombre, boolean tieneReserva) {
        Estudiante estudiante = new Estudiante(nombre, tieneReserva);

        if (tieneReserva) {
            colaIngreso.addFirst(estudiante); // Turno preferencial al inicio
            System.out.println("Turno PREFERENCIAL agregado: " + estudiante);
        } else {
            colaIngreso.addLast(estudiante); // Turno normal al final
            System.out.println("Turno NORMAL agregado: " + estudiante);
        }
    }

    public Estudiante atenderSiguiente() {
        if (colaIngreso.isEmpty()) {
            return null;
        }
        return colaIngreso.removeFirst();
    }

    public void mostrarCola() {
        System.out.println("\n--- COLA ACTUAL ---");
        int posicion = 1;
        for (Estudiante estudiante : colaIngreso) {
            System.out.println(posicion + ". " + estudiante);
            posicion++;
        }
        System.out.println("-------------------\n");
    }
}