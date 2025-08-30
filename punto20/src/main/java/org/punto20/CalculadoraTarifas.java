package org.punto20;

import java.math.BigDecimal;
import java.util.TreeMap;
import java.util.Map;

public class CalculadoraTarifas {
    private TreeMap<Integer, BigDecimal> tarifasPorPeso;

    public CalculadoraTarifas() {
        tarifasPorPeso = new TreeMap<>();
    }

    public void agregarTramo(int pesoMaximo, BigDecimal tarifa) {
        tarifasPorPeso.put(pesoMaximo, tarifa);
    }

    public BigDecimal calcularTarifa(int pesoVehiculo) {
        // Usar floorEntry para encontrar el tramo aplicable
        Map.Entry<Integer, BigDecimal> tramo = tarifasPorPeso.floorEntry(pesoVehiculo);

        if (tramo != null) {
            return tramo.getValue();
        } else {
            // Si no hay tramo aplicable (peso muy bajo), usar el primer tramo
            Map.Entry<Integer, BigDecimal> primerTramo = tarifasPorPeso.firstEntry();
            if (primerTramo != null) {
                return primerTramo.getValue();
            }
        }

        return BigDecimal.ZERO; // Si no hay tarifas definidas
    }

    public void mostrarTarifas() {
        System.out.println("\n=== TARIFAS POR TRAMO DE PESO ===");
        int tramoMin = 0;

        for (Map.Entry<Integer, BigDecimal> entry : tarifasPorPeso.entrySet()) {
            System.out.println("Hasta " + entry.getKey() + " kg: $" + entry.getValue());
            tramoMin = entry.getKey() + 1;
        }
    }
}
