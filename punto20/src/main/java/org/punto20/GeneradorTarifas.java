package org.punto20;

import java.math.BigDecimal;

public class GeneradorTarifas {

    public static void configurarTarifasEjemplo(CalculadoraTarifas calculadora) {
        calculadora.agregarTramo(1000, new BigDecimal("5.00"));
        calculadora.agregarTramo(2000, new BigDecimal("8.50"));
        calculadora.agregarTramo(3500, new BigDecimal("12.00"));
        calculadora.agregarTramo(5000, new BigDecimal("18.75"));
        calculadora.agregarTramo(8000, new BigDecimal("25.00"));
    }
}
