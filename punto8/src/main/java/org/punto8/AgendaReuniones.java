package org.punto8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.NavigableSet;
import java.util.TreeSet;

public class AgendaReuniones {
    private TreeSet<Reunion> reuniones;

    public AgendaReuniones() {
        this.reuniones = new TreeSet<>();
    }

    // Agregar reunión
    public void agregarReunion(Reunion reunion) {
        reuniones.add(reunion);
    }

    // Obtener primera reunión
    public Reunion getPrimeraReunion() {
        return reuniones.isEmpty() ? null : reuniones.first();
    }

    // Obtener última reunión
    public Reunion getUltimaReunion() {
        return reuniones.isEmpty() ? null : reuniones.last();
    }

    // Reuniones de hoy hasta fin de mes
    public NavigableSet<Reunion> getReunionesHoyHastaFinMes() {
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime finDeMes = LocalDateTime.of(
                LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()),
                LocalTime.MAX
        );

        return reuniones.subSet(
                new Reunion(hoy, ""),
                true,
                new Reunion(finDeMes, ""),
                true
        );
    }

    // Todas las reuniones ordenadas
    public void mostrarTodasReuniones() {
        reuniones.forEach(System.out::println);
    }

    // Cantidad de reuniones
    public int cantidadReuniones() {
        return reuniones.size();
    }
}
