import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Indice
{
    private Map<String, TreeSet<Integer>> indice;

    public Indice()
    {
        indice = new HashMap<>();
    }

    public void agregar(String palabra, int pagina)
    {
        indice.computeIfAbsent(palabra.toLowerCase(), k -> new TreeSet<>()).add(pagina);
    }

    public TreeSet<Integer> consultar(String palabra)
    {
        return indice.getOrDefault(palabra.toLowerCase(), new TreeSet<>());
    }

    public void mostrarIndice()
    {
        System.out.println("\n📖 Índice completo:");
        for (Map.Entry<String, TreeSet<Integer>> entry : indice.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Indice indice = new Indice();
        indice.agregar("java", 10);
        indice.agregar("java", 5);
        indice.agregar("java", 20);
        indice.agregar("estructura", 7);
        indice.agregar("estructura", 5);
        indice.agregar("estructura", 7);
        indice.agregar("algoritmos", 15);
        indice.agregar("algoritmos", 2);
        indice.mostrarIndice();
        System.out.println("\nPáginas con 'java': " + indice.consultar("java"));
        System.out.println("Páginas con 'estructura': " + indice.consultar("estructura"));
        System.out.println("Páginas con 'python': " + indice.consultar("python")); // no existe
    }
}
