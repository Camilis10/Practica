import java.util.Comparator;
import java.util.TreeSet;

class Deportista
{
    private String nombre;
    private String apellido;
    private int puntaje;

    public Deportista(String nombre, String apellido, int puntaje)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntaje = puntaje;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getPuntaje() { return puntaje; }

    @Override
    public String toString()
    {
        return apellido + ", " + nombre + " → " + puntaje;
    }
}

public class Main
{
    public static void main(String[] args)
    {

        Comparator<Deportista> rankingComparator = Comparator
                .comparingInt(Deportista::getPuntaje).reversed()
                .thenComparing(Deportista::getApellido)
                .thenComparing(Deportista::getNombre);

        TreeSet<Deportista> ranking = new TreeSet<>(rankingComparator);

        ranking.add(new Deportista("Carlos", "Gómez", 95));
        ranking.add(new Deportista("Ana", "Martínez", 100));
        ranking.add(new Deportista("Luis", "Martínez", 100));  // empate en puntaje, orden por apellido
        ranking.add(new Deportista("María", "Fernández", 88));
        ranking.add(new Deportista("Pedro", "Alvarez", 95));   // empate en puntaje con Carlos Gómez
        ranking.add(new Deportista("Sofía", "Zapata", 75));
        ranking.add(new Deportista("Jorge", "Martínez", 100)); // triple empate
        ranking.add(new Deportista("Lucía", "Alvarez", 88));   // empate con María
        ranking.add(new Deportista("Andrés", "Torres", 92));
        ranking.add(new Deportista("Valentina", "Suárez", 60));
        ranking.add(new Deportista("Mateo", "Ramírez", 80));

        System.out.println("Ranking completo:");
        int pos = 1;
        for (Deportista d : ranking)
        {
            System.out.println(pos + ". " + d);
            pos++;
        }

        System.out.println("\n Top 10:");
        pos = 1;
        for (Deportista d : ranking)
        {
            if (pos > 10) break;
            System.out.println(pos + ". " + d);
            pos++;
        }
    }
}