package org.punto10;

public class Main {
    public static void main(String[] args) {
        FacturaSupermercado factura = new FacturaSupermercado();

        // Simular escaneo de productos en orden
        factura.escanearProducto("Leche", 2.50, 2);
        factura.escanearProducto("Pan", 1.20, 3);
        factura.escanearProducto("Leche", 2.50, 1); // Producto repetido
        factura.escanearProducto("Huevos", 3.80, 1);
        factura.escanearProducto("Pan", 1.20, 2); // Producto repetido
        factura.escanearProducto("Arroz", 4.50, 2);

        // Imprimir factura final
        factura.imprimirFactura();
    }
}