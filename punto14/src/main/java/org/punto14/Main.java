package org.punto14;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Generar datos de ejemplo
        Set<String> correos = GeneradorDatos.generarCorreosEjemplo();
        Set<String> dominiosVetados = GeneradorDatos.generarDominiosVetados();

        // Mostrar datos iniciales
        System.out.println("=== DATOS INICIALES ===");
        System.out.println("Correos a procesar: " + correos.size());
        System.out.println("Dominios vetados: " + dominiosVetados);

        // Crear depurador y procesar
        DepuradorCorreos depurador = new DepuradorCorreos(correos, dominiosVetados);
        int cantidadInicial = depurador.getCantidadCorreos();

        // Realizar depuración
        int eliminados = depurador.depurarCorreos();

        // Mostrar resultados
        Verificador.mostrarResultados(depurador.getCorreos(), cantidadInicial, eliminados);

        // Explicación
        System.out.println("\n=== EXPLICACIÓN ===");
        System.out.println("Se utilizó Iterator.remove() para eliminar elementos de forma segura");
        System.out.println("durante la iteración, evitando ConcurrentModificationException.");
    }
}