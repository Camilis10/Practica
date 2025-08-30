package org.punto8;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AgendaReuniones agenda = new AgendaReuniones();

        // Agregar reuniones
        agenda.agregarReunion(new Reunion(
                LocalDateTime.of(2024, 3, 15, 10, 0),
                "Revisión de proyecto"
        ));

        agenda.agregarReunion(new Reunion(
                LocalDateTime.of(2024, 3, 10, 14, 30),
                "Reunión de equipo"
        ));

        // Mostrar ordenadas
        System.out.println("Todas las reuniones:");
        agenda.mostrarTodasReuniones();

        // Primera y última
        System.out.println("\nPrimera reunión: " + agenda.getPrimeraReunion());
        System.out.println("Última reunión: " + agenda.getUltimaReunion());
    }
}