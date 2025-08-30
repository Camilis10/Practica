package org.punto18;

public class Main {
    public static void main(String[] args) {
        // Crear lista de reproducción
        ListaReproduccion lista = new ListaReproduccion();

        // Generar canciones de ejemplo
        Cancion[] canciones = GeneradorCanciones.generarCancionesEjemplo();

        // Agregar canciones a la lista
        System.out.println("=== AGREGANDO CANCIONES ===");
        for (Cancion cancion : canciones) {
            lista.agregarCancion(cancion);
            System.out.println("✓ " + cancion);
        }

        System.out.println("\nTotal de canciones: " + lista.getTotalCanciones());

        // Demostrar navegación
        ControladorReproduccion.demostrarNavegacion(lista);

        // Demostrar reordenamiento
        ControladorReproduccion.demostrarReordenamiento(lista);

        // Explicación
        System.out.println("\n=== EXPLICACIÓN ===");
        System.out.println("Solución al ConcurrentModificationException:");
        System.out.println("- Usamos índices en lugar de ListIterator para navegación");
        System.out.println("- Evitamos el problema de modificación concurrente");
        System.out.println("- Mantenemos toda la funcionalidad original");
        System.out.println("- LinkedList sigue siendo ideal para reordenamiento frecuente");
    }
}