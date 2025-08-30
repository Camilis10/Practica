package org.punto18;

public class GeneradorCanciones {

    public static Cancion[] generarCancionesEjemplo() {
        return new Cancion[] {
                new Cancion("Bohemian Rhapsody", "Queen", 355),
                new Cancion("Imagine", "John Lennon", 183),
                new Cancion("Hotel California", "Eagles", 391),
                new Cancion("Yesterday", "The Beatles", 125),
                new Cancion("Smells Like Teen Spirit", "Nirvana", 301),
                new Cancion("Like a Rolling Stone", "Bob Dylan", 370)
        };
    }
}
