package org.punto16;

public class GeneradorTrabajos {

    public static Trabajo[] generarTrabajosEjemplo() {
        return new Trabajo[] {
                new Trabajo("Informe Mensual", 50),
                new Trabajo("Factura Cliente A", 3),
                new Trabajo("Presentación Ejecutiva", 25),
                new Trabajo("Contrato Legal", 15),
                new Trabajo("Boleta Pago", 2),
                new Trabajo("Reporte Diario", 5),
                new Trabajo("Propuesta Comercial", 30),
                new Trabajo("Memo Interno", 2)
        };
    }
}
