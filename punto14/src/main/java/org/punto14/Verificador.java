package org.punto14;

import java.util.Set;

public class Verificador {

    public static void mostrarResultados(Set<String> correos, int cantidadInicial, int eliminados) {
        System.out.println("=== RESULTADOS DE DEPURACIÓN ===");
        System.out.println("Correos iniciales: " + cantidadInicial);
        System.out.println("Correos eliminados: " + eliminados);
        System.out.println("Correos restantes: " + correos.size());

        System.out.println("\n=== CORREOS RESTANTES ===");
        if (correos.isEmpty()) {
            System.out.println("No hay correos restantes.");
        } else {
            int i = 1;
            for (String correo : correos) {
                System.out.println(i + ". " + correo);
                i++;
            }
        }
    }
}
