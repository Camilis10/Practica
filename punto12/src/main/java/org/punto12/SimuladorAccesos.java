package org.punto12;

public class SimuladorAccesos {

    public static void simularAccesosConcurrentes(ContadorConcurrente contador, int numHilos, int accesosPorHilo) {
        String[] usuarios = {"usuario1", "usuario2", "usuario3", "usuario4", "usuario5"};

        Thread[] hilos = new Thread[numHilos];

        System.out.println("Iniciando simulación con " + numHilos + " hilos...");

        for (int i = 0; i < hilos.length; i++) {
            final int index = i;
            hilos[i] = new Thread(() -> {
                // Cada hilo realiza múltiples incrementos
                for (int j = 0; j < accesosPorHilo; j++) {
                    String usuario = usuarios[index % usuarios.length];
                    contador.incrementarContador(usuario);

                    // Pequeña pausa para simular procesamiento real
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido: " + e.getMessage());
            }
        }

        System.out.println("Simulación completada.");
    }
}
