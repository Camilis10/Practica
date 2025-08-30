import java.util.HashMap;
import java.util.Map;

class Producto
{
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre()
    {
        return nombre;
    }

    public double getPrecio()
    {
        return precio;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }
    @Override
    public String toString()
    {
        return nombre + " | $" + precio + " | Stock: " + stock;
    }
}

class Ferreteria
{
    private Map<String, Producto> inventario;

    public Ferreteria()
    {
        inventario = new HashMap<>();
    }

    public void agregarProducto(String codigo, Producto producto)
    {
        inventario.put(codigo, producto);
    }

    public void actualizarStock(String codigo, int nuevoStock)
    {
        Producto p = inventario.get(codigo);
        if (p != null)
        {
            p.setStock(nuevoStock);
            System.out.println("Stock actualizado para " + p.getNombre() + ": " + nuevoStock);
        }
        else
        {
            System.out.println("Producto no encontrado con código: " + codigo);
        }
    }

    public void consultarPrecio(String codigo)
    {
        Producto p = inventario.get(codigo);
        if (p != null)
        {
            System.out.println("Precio de " + p.getNombre() + ": $" + p.getPrecio());
        }
        else
        {
            System.out.println("No existe producto con código: " + codigo);
        }
    }

    public void listarFaltantes()
    {
        System.out.println("\nProductos faltantes (stock=0):");
        boolean hayFaltantes = false;
        for (Map.Entry<String, Producto> entry : inventario.entrySet()) {
            if (entry.getValue().getStock() == 0) {
                System.out.println("Código: " + entry.getKey() + " → " + entry.getValue());
                hayFaltantes = true;
            }
        }
        if (!hayFaltantes)
        {
            System.out.println("No hay productos faltantes.");
        }
    }

    public void mostrarInventario()
    {
        System.out.println("\nInventario completo:");
        for (Map.Entry<String, Producto> entry : inventario.entrySet())
        {
            System.out.println("Código: " + entry.getKey() + " → " + entry.getValue());
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Ferreteria ferreteria = new Ferreteria();
        ferreteria.agregarProducto("A01", new Producto("Martillo", 25000, 10));
        ferreteria.agregarProducto("A02", new Producto("Destornillador", 8000, 0));
        ferreteria.agregarProducto("A03", new Producto("Taladro", 120000, 5));
        ferreteria.agregarProducto("A04", new Producto("Cinta métrica", 5000, 0));
        ferreteria.mostrarInventario();
        ferreteria.consultarPrecio("A03");
        ferreteria.actualizarStock("A02", 15);
        ferreteria.listarFaltantes();
        ferreteria.mostrarInventario();
    }
}
