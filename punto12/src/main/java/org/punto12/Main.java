package org.punto12;

public class Main {
    public static void main(String[] args) {
        // Crear instancia del contador
        ContadorConcurrente contador = new ContadorConcurrente();

        // Simular accesos concurrentes
        SimuladorAccesos.simularAccesosConcurrentes(contador, 10, 100);

        // Mostrar resultados
        contador.mostrarTopN(3);

        // Mostrar diferencias entre Hashtable y HashMap
        ComparadorHashtableHashMap.mostrarDiferencias();

        // Mostrar total de accesos (opcional)
        System.out.println("\n=== TOTAL DE ACCESOS ===");
        int total = 0;
        for (int count : contador.getContadores().values()) {
            total += count;
        }
        System.out.println("Total de accesos registrados: " + total);
    }
}