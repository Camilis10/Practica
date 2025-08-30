import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Libro {
    private String titulo;
    private String autor;
    private int anio;
    private String isbn;

    public Libro(String titulo, String autor, int anio, String isbn)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString()
    {
        return titulo + " - " + autor + " (" + anio + ") ISBN: " + isbn;
    }
}

class Biblioteca
{
    private List<Libro> libros;

    public Biblioteca()
    {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro)
    {
        libros.add(libro);
    }

    public boolean eliminarPorIsbn(String isbn)
    {
        return libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    public List<Libro> buscarPorAutor(String autor)
    {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros)
        {
            if (libro.getAutor().equalsIgnoreCase(autor))
            {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public List<Libro> listarPorAnioAsc()
    {
        List<Libro> copia = new ArrayList<>(libros);
        Collections.sort(copia, Comparator.comparingInt(Libro::getAnio));
        return copia;
    }

    public List<Libro> obtener5MasRecientes()
    {
        List<Libro> copia = new ArrayList<>(libros);
        copia.sort(Comparator.comparingInt(Libro::getAnio).reversed());
        return copia.subList(0, Math.min(5, copia.size()));
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "12345"));
        biblioteca.agregarLibro(new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", 1985, "67890"));
        biblioteca.agregarLibro(new Libro("Rayuela", "Julio Cortázar", 1963, "54321"));
        biblioteca.agregarLibro(new Libro("1984", "George Orwell", 1949, "11223"));
        biblioteca.agregarLibro(new Libro("Fahrenheit 451", "Ray Bradbury", 1953, "44556"));
        biblioteca.agregarLibro(new Libro("Ensayo sobre la ceguera", "José Saramago", 1995, "77889"));
        System.out.println("Libros de Gabriel García Márquez:");
        biblioteca.buscarPorAutor("Gabriel García Márquez").forEach(System.out::println);
        System.out.println("\nLibros por año ascendente:");
        biblioteca.listarPorAnioAsc().forEach(System.out::println);
        System.out.println("\nLos 5 más recientes:");
        biblioteca.obtener5MasRecientes().forEach(System.out::println);
        System.out.println("\nEliminando libro ISBN 12345...");
        biblioteca.eliminarPorIsbn("12345");
        System.out.println("\nLibros restantes:");
        biblioteca.listarPorAnioAsc().forEach(System.out::println);
    }
}