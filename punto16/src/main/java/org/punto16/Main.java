package org.punto16;

public class Main {
    public static void main(String[] args) {
        // Crear planificador
        PlanificadorImpresiones planificador = new PlanificadorImpresiones();

        // Generar trabajos de ejemplo
        Trabajo[] trabajos = GeneradorTrabajos.generarTrabajosEjemplo();

        // Agregar trabajos al planificador
        System.out.println("=== AGREGANDO TRABAJOS A LA COLA ===");
        for (Trabajo trabajo : trabajos) {
            planificador.agregarTrabajo(trabajo);
        }

        // Mostrar estado inicial
        System.out.println("\nTotal de trabajos en cola: " + planificador.getCantidadTrabajos());

        // Simular proceso de impresión
        SimuladorImpresion.simularImpresion(planificador);

        // Explicación
        System.out.println("\n=== EXPLICACIÓN ===");
        System.out.println("PriorityQueue ordena los trabajos automáticamente:");
        System.out.println("- Primero por tamaño (menor número de páginas primero)");
        System.out.println("- En caso de empate, por antigüedad (más antiguo primero)");
        System.out.println("- Esto optimiza el tiempo total de impresión");
    }
}