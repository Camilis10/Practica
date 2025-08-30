import java.time.LocalDate;
import java.util.*;

class Actividad {
    private String nombre;
    private String descripcion;

    public Actividad(String nombre, String descripcion)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    @Override
    public String toString()
    {
        return nombre + " (" + descripcion + ")";
    }
}

class AgendaAcademica
{
    private TreeMap<LocalDate, List<Actividad>> agenda;

    public AgendaAcademica() {
        agenda = new TreeMap<>();
    }

    public void agregarActividad(LocalDate fecha, Actividad actividad) {
        agenda.computeIfAbsent(fecha, k -> new ArrayList<>()).add(actividad);
    }

    public Map.Entry<LocalDate, List<Actividad>> obtenerProxima() {
        LocalDate hoy = LocalDate.now();
        return agenda.ceilingEntry(hoy); // primera clave >= hoy
    }

    public SortedMap<LocalDate, List<Actividad>> reporteEntre(LocalDate inicio, LocalDate fin) {
        return agenda.subMap(inicio, true, fin, true);
    }

    public void mostrarAgenda()
    {
        System.out.println("\nAgenda completa:");
        for (Map.Entry<LocalDate, List<Actividad>> entry : agenda.entrySet())
        {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        AgendaAcademica agenda = new AgendaAcademica();
        agenda.agregarActividad(LocalDate.of(2025, 9, 1), new Actividad("Clase de Matemáticas", "Tema: Integrales"));
        agenda.agregarActividad(LocalDate.of(2025, 9, 3), new Actividad("Examen Física", "Capítulos 1-4"));
        agenda.agregarActividad(LocalDate.of(2025, 9, 3), new Actividad("Reunión Proyecto", "Equipo de investigación"));
        agenda.agregarActividad(LocalDate.of(2025, 9, 5), new Actividad("Entrega de Tarea", "Programación en Java"));
        agenda.mostrarAgenda();
        System.out.println("\nPróxima actividad (a partir de hoy " + LocalDate.now() + "):");
        Map.Entry<LocalDate, List<Actividad>> proxima = agenda.obtenerProxima();
        if (proxima != null)
        {
            System.out.println(proxima.getKey() + " → " + proxima.getValue());
        }
        else
        {
            System.out.println("No hay actividades próximas.");
        }
        System.out.println("\nReporte entre 2025-09-02 y 2025-09-04:");
        SortedMap<LocalDate, List<Actividad>> reporte = agenda.reporteEntre(
                LocalDate.of(2025, 9, 2),
                LocalDate.of(2025, 9, 4)
        );
        for (Map.Entry<LocalDate, List<Actividad>> entry : reporte.entrySet())
        {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}