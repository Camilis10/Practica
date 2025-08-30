package org.punto6;

import java.util.HashSet;
import java.util.Scanner;

public class ControlAccesoHuella {

    public static void main(String[] args) {
        // Crear el HashSet para almacenar las huellas
        HashSet<String> huellas = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA SIMPLE DE CONTROL POR HUELLA ===");

        // Probar con algunas huellas de ejemplo
        probarHuellas(huellas);

        // Modo interactivo simple
        modoInteractivo(huellas, scanner);

        scanner.close();
    }

    // Método para probar huellas duplicadas
    public static void probarHuellas(HashSet<String> huellas) {
        System.out.println("\n--- Probando huellas duplicadas ---");

        // Huellas de prueba (algunas repetidas)
        String[] huellasPrueba = {"A1B2C3", "X7Y8Z9", "A1B2C3", "M4N5O6", "X7Y8Z9"};

        for (String huella : huellasPrueba) {
            if (huellas.contains(huella)) {
                System.out.println("❌ Huella " + huella + " YA EXISTE (no se agregó)");
            } else {
                huellas.add(huella);
                System.out.println("✅ Huella " + huella + " agregada");
            }
            System.out.println("Total de huellas: " + huellas.size());
        }
    }

    // Método para el modo interactivo
    public static void modoInteractivo(HashSet<String> huellas, Scanner scanner) {
        System.out.println("\n--- Modo interactivo ---");

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Registrar huella");
            System.out.println("2. Verificar acceso");
            System.out.println("3. Mostrar todas las huellas");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarHuella(huellas, scanner);
                    break;
                case 2:
                    verificarAcceso(huellas, scanner);
                    break;
                case 3:
                    mostrarHuellas(huellas);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    // Método para registrar una huella
    public static void registrarHuella(HashSet<String> huellas, Scanner scanner) {
        System.out.print("Ingresa el ID de la huella: ");
        String idHuella = scanner.nextLine();

        if (huellas.contains(idHuella)) {
            System.out.println("❌ ERROR: Esta huella ya está registrada");
        } else {
            huellas.add(idHuella);
            System.out.println("✅ Huella registrada correctamente");
        }
        System.out.println("Total de huellas: " + huellas.size());
    }

    // Método para verificar acceso
    public static void verificarAcceso(HashSet<String> huellas, Scanner scanner) {
        System.out.print("Ingresa el ID de la huella a verificar: ");
        String idHuella = scanner.nextLine();

        if (huellas.contains(idHuella)) {
            System.out.println("✅ ACCESO PERMITIDO");
        } else {
            System.out.println("❌ ACCESO DENEGADO - Huella no registrada");
        }
    }

    // Método para mostrar todas las huellas
    public static void mostrarHuellas(HashSet<String> huellas) {
        System.out.println("\n--- Huellas registradas ---");

        if (huellas.isEmpty()) {
            System.out.println("No hay huellas registradas");
        } else {
            int numero = 1;
            for (String huella : huellas) {
                System.out.println(numero + ". " + huella);
                numero++;
            }
        }
        System.out.println("Total: " + huellas.size() + " huellas únicas");
    }
}