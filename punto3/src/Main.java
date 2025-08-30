import java.util.Stack;

interface Operacion
{
    void ejecutar();
    void deshacer();
    String getNombre();
}

class Rotar implements Operacion
{
    @Override
    public void ejecutar()
    {
        System.out.println("Ejecutando: Rotar imagen");
    }

    @Override
    public void deshacer()
    {
        System.out.println("Deshaciendo: Rotar imagen");
    }

    @Override
    public String getNombre()
    {
        return "Rotar";
    }
}

class Recortar implements Operacion
{
    @Override
    public void ejecutar()
    {
        System.out.println("Ejecutando: Recortar imagen");
    }

    @Override
    public void deshacer()
    {
        System.out.println("Deshaciendo: Recortar imagen");
    }

    @Override
    public String getNombre()
    {
        return "Recortar";
    }
}

class Brillo implements Operacion
{
    @Override
    public void ejecutar()
    {
        System.out.println("Ejecutando: Ajustar brillo");
    }

    @Override
    public void deshacer()
    {
        System.out.println("Deshaciendo: Ajustar brillo");
    }

    @Override
    public String getNombre()
    {
        return "Brillo";
    }
}

class Editor
{
    private Stack<Operacion> historial = new Stack<>();

    public void aplicarOperacion(Operacion op)
    {
        op.ejecutar();
        historial.push(op);
    }

    public void deshacer()
    {
        if (!historial.isEmpty())
        {
            Operacion ultima = historial.pop();
            ultima.deshacer();
        }
        else
        {
            System.out.println("No hay operaciones para deshacer.");
        }
    }

    public void mostrarHistorial()
    {
        System.out.println("Historial actual:");
        if (historial.isEmpty())
        {
            System.out.println("  (Vacío)");
        }
        else
        {
            for (Operacion op : historial)
            {
                System.out.println(" - " + op.getNombre());
            }
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Editor editor = new Editor();
        editor.aplicarOperacion(new Rotar());
        editor.aplicarOperacion(new Brillo());
        editor.aplicarOperacion(new Recortar());
        editor.aplicarOperacion(new Brillo());
        editor.aplicarOperacion(new Rotar());
        System.out.println("\nEstado después de aplicar operaciones:");
        editor.mostrarHistorial();
        System.out.println("\n*** Deshaciendo 3 operaciones ***");
        editor.deshacer();
        editor.deshacer();
        editor.deshacer();
        System.out.println("\nEstado después de 3 undo:");
        editor.mostrarHistorial();
    }
}