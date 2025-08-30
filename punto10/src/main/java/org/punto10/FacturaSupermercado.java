package org.punto10;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacturaSupermercado {
    private LinkedHashMap<String, Detalle> factura;

    public FacturaSupermercado() {
        this.factura = new LinkedHashMap<>();
    }

    public void escanearProducto(String nombre, double precio, int cantidad) {
        if (factura.containsKey(nombre)) {
            // Producto ya existe, sumar cantidad
            Detalle existente = factura.get(nombre);
            existente.agregarCantidad(cantidad);
        } else {
            // Producto nuevo
            factura.put(nombre, new Detalle(nombre, precio, cantidad));
        }
    }

    public void imprimirFactura() {
        double subtotal = calcularSubtotal();
        double iva = subtotal * 0.16;
        double total = subtotal + iva;

        System.out.println("=== FACTURA ===");
        System.out.println("Producto\tPrecio\tCant\tSubtotal");
        System.out.println("-----------------------------------");

        for (Map.Entry<String, Detalle> entry : factura.entrySet()) {
            Detalle d = entry.getValue();
            System.out.printf("%-10s\t%.2f\t%d\t%.2f%n",
                    d.getNombre(), d.getPrecio(), d.getCantidad(), d.getSubtotal());
        }

        System.out.println("-----------------------------------");
        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("IVA (16%%): %.2f%n", iva);
        System.out.printf("TOTAL: %.2f%n", total);
    }

    private double calcularSubtotal() {
        double subtotal = 0;
        for (Detalle detalle : factura.values()) {
            subtotal += detalle.getSubtotal();
        }
        return subtotal;
    }
}
