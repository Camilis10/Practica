package org.punto20;

import java.math.BigDecimal;

public class SimuladorPeaje {

    public static void simularCalculos(CalculadoraTarifas calculadora) {
        System.out.println("\n=== SIMULACIÓN DE CÁLCULOS ===");

        int[] pesosEjemplo = {500, 1500, 2500, 4000, 6000, 10000};

        for (int peso : pesosEjemplo) {
            BigDecimal tarifa = calculadora.calcularTarifa(peso);
            System.out.println("Vehículo de " + peso + " kg: $" + tarifa);
        }
    }

    public static void demostrarFloorCeiling(CalculadoraTarifas calculadora) {
        System.out.println("\n=== DEMOSTRACIÓN FLOOR/CEILING ===");

        // Mostrar cómo funciona floorEntry para diferentes pesos
        int[] pesosTest = {999, 1000, 1001, 3500, 3501, 10000};

        for (int peso : pesosTest) {
            BigDecimal tarifa = calculadora.calcularTarifa(peso);
            System.out.println("Peso: " + peso + " kg -> Tarifa: $" + tarifa);
        }
    }
}
