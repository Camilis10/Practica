package org.punto18;

public class ControladorReproduccion {

    public static void demostrarNavegacion(ListaReproduccion lista) {
        System.out.println("\n=== DEMOSTRACIÓN DE NAVEGACIÓN ===");

        // Avanzar algunas canciones
        System.out.println("Avanzando a la primera canción...");
        lista.siguiente();
        lista.mostrarLista();

        System.out.println("\nAvanzando a la siguiente...");
        lista.siguiente();
        lista.mostrarLista();

        System.out.println("\nRetrocediendo...");
        lista.anterior();
        lista.mostrarLista();

        System.out.println("\nAvanzando dos más...");
        lista.siguiente();
        lista.siguiente();
        lista.mostrarLista();
    }

    public static void demostrarReordenamiento(ListaReproduccion lista) {
        System.out.println("\n=== DEMOSTRACIÓN DE REORDENAMIENTO ===");

        System.out.println("Moviendo canción de posición 4 a posición 1...");
        lista.moverCancion(3, 0); // Índices base 0
        lista.mostrarLista();

        System.out.println("\nMoviendo canción de posición 2 a posición 5...");
        lista.moverCancion(1, 4);
        lista.mostrarLista();
    }
}
