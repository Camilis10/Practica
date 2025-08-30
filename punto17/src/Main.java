import java.util.ArrayDeque;

class Lote
{
    private String nombre;

    public Lote(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return nombre;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        ArrayDeque<Lote> cola = new ArrayDeque<>();

        cola.addLast(new Lote("Lote-1"));
        cola.addLast(new Lote("Lote-2"));
        cola.addLast(new Lote("Lote-3"));

        System.out.println("Cola inicial: " + cola);

        cola.addFirst(new Lote("URGENTE-A"));
        System.out.println("Tras inyectar URGENTE-A: " + cola);

        cola.addLast(new Lote("Lote-4"));
        cola.addLast(new Lote("Lote-5"));

        cola.addFirst(new Lote("URGENTE-B"));
        System.out.println("Tras inyectar URGENTE-B: " + cola);

        System.out.println("\n🔹 Procesando lotes:");
        while (!cola.isEmpty())
        {
            Lote actual = cola.removeFirst();
            System.out.println("Ejecutando → " + actual);
        }
    }
}