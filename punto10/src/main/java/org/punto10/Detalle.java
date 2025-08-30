package org.punto10;

public class Detalle {
    private String nombre;
    private double precio;
    private int cantidad;
    private double subtotal;

    public Detalle(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = precio * cantidad;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }

    // Método para agregar cantidad
    public void agregarCantidad(int cantidad) {
        this.cantidad += cantidad;
        this.subtotal = this.precio * this.cantidad;
    }
}
