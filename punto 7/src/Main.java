import java.util.LinkedHashSet;
import java.util.Set;

class Curso {
    private String nombre;

    public Curso(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso = (Curso) o;
        return nombre.equalsIgnoreCase(curso.nombre);
    }

    @Override
    public int hashCode()
    {
        return nombre.toLowerCase().hashCode();
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
        Set<Curso> favoritos = new LinkedHashSet<>();
        favoritos.add(new Curso("Java Básico"));
        favoritos.add(new Curso("Python Avanzado"));
        favoritos.add(new Curso("Machine Learning"));
        favoritos.add(new Curso("Java Básico"));
        System.out.println("Cursos favoritos iniciales:");
        System.out.println(favoritos);
        favoritos.remove(new Curso("Python Avanzado"));
        System.out.println("\nTras eliminar 'Python Avanzado':");
        System.out.println(favoritos);
        favoritos.add(new Curso("Bases de Datos"));
        System.out.println("\nTras agregar 'Bases de Datos':");
        System.out.println(favoritos);
        favoritos.add(new Curso("Python Avanzado"));
        System.out.println("\nTras reinsertar 'Python Avanzado':");
        System.out.println(favoritos);
    }
}