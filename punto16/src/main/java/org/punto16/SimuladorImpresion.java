package org.punto16;

public class SimuladorImpresion {

    public static void simularImpresion(PlanificadorImpresiones planificador) {
        System.out.println("\n=== INICIANDO PROCESO DE IMPRESIÓN ===");

        int tiempoTotal = 0;
        int trabajoNumero = 1;

        while (planificador.hayTrabajosPendientes()) {
            Trabajo trabajo = planificador.procesarSiguiente();

            // Simular tiempo de impresión (1 segundo por página)
            int tiempoImpresion = trabajo.getTamaño();
            tiempoTotal += tiempoImpresion;

            System.out.println(trabajoNumero + ". Imprimiendo: " + trabajo +
                    " - Tiempo: " + tiempoImpresion + " segundos");

            // Simular espera
            try {
                Thread.sleep(100); // 100ms por simulación
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            trabajoNumero++;
        }

        System.out.println("\n=== PROCESO COMPLETADO ===");
        System.out.println("Tiempo total de impresión: " + tiempoTotal + " segundos");
    }
}
