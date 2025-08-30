package org.punto20;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Crear calculadora de tarifas
        CalculadoraTarifas calculadora = new CalculadoraTarifas();

        // Configurar tarifas de ejemplo
        System.out.println("=== CONFIGURANDO TARIFAS ===");
        GeneradorTarifas.configurarTarifasEjemplo(calculadora);
        calculadora.mostrarTarifas();

        // Simular cálculos
        SimuladorPeaje.simularCalculos(calculadora);

        // Demostrar funcionamiento de floorEntry/ceilingEntry
        SimuladorPeaje.demostrarFloorCeiling(calculadora);

        // Explicación
        System.out.println("\n=== EXPLICACIÓN ===");
        System.out.println("TreeMap.floorEntry(peso) encuentra:");
        System.out.println("- La entrada con clave menor o igual al peso dado");
        System.out.println("- Perfecto para tarifas por tramos (rangos)");
        System.out.println("- Ej: floorEntry(1500) encuentra el tramo de 1000 kg");
        System.out.println("- Ej: floorEntry(10000) encuentra el tramo de 8000 kg");
        System.out.println("\nTreeMap.ceilingEntry() encontraría:");
        System.out.println("- La entrada con clave mayor o igual al peso dado");
        System.out.println("- Útil para otros tipos de búsquedas");
    }
}