package org.punto6;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Crear HashSet para almacenar IDs de huellas
        HashSet<String> huellas = new HashSet<>();

        System.out.println("=== PRUEBA DE DUPLICADOS CON HASHSET ===");
        System.out.println("Tamaño inicial: " + huellas.size());

        // Intentar agregar huellas (algunas repetidas)
        String[] idsHuellas = {
                "FP_123", "FP_456", "FP_123", // FP_123 está duplicado
                "FP_789", "FP_456", "FP_999"  // FP_456 está duplicado
        };

        for (String id : idsHuellas) {
            System.out.println("\nIntentando agregar: " + id);

            if (huellas.add(id)) {
                System.out.println("✅ Agregado exitosamente");
            } else {
                System.out.println("❌ NO se agregó (ya existe)");
            }

            System.out.println("Tamaño actual: " + huellas.size());
        }

        // Mostrar resultado final
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Huellas únicas registradas:");
        for (String huella : huellas) {
            System.out.println("- " + huella);
        }
        System.out.println("Total: " + huellas.size() + " huellas únicas");

        // Demostrar que el tamaño no aumenta con duplicados
        System.out.println("\nIntentos: " + idsHuellas.length);
        System.out.println("Éxitos: " + huellas.size());
        System.out.println("Duplicados bloqueados: " + (idsHuellas.length - huellas.size()));
    }
}