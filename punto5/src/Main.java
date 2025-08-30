import java.util.ArrayDeque;

class Navegador {
    private ArrayDeque<String> atras;
    private ArrayDeque<String> adelante;
    private String paginaActual;

    public Navegador()
    {
        atras = new ArrayDeque<>();
        adelante = new ArrayDeque<>();
        paginaActual = "about:blank";
    }

    public void visitar(String url)
    {
        if (paginaActual != null)
        {
            atras.push(paginaActual);
        }
        paginaActual = url;
        adelante.clear();
        System.out.println("Visitando: " + paginaActual);
    }

    public void irAtras()
    {
        if (!atras.isEmpty())
        {
            adelante.push(paginaActual);
            paginaActual = atras.pop();
            System.out.println("Atrás → " + paginaActual);
        }
        else
        {
            System.out.println("No hay páginas atrás.");
        }
    }

    public void irAdelante()
    {
        if (!adelante.isEmpty())
        {
            atras.push(paginaActual);
            paginaActual = adelante.pop();
            System.out.println("Adelante → " + paginaActual);
        }
        else
        {
            System.out.println("No hay páginas adelante.");
        }
    }

    public void mostrarEstado()
    {
        System.out.println("\n--- Estado del Navegador ---");
        System.out.println("Página actual: " + paginaActual);
        System.out.println("Atrás: " + atras);
        System.out.println("Adelante: " + adelante);
        System.out.println("---------------------------\n");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Navegador nav = new Navegador();
        nav.visitar("google.com");
        nav.visitar("youtube.com");
        nav.visitar("wikipedia.org");
        nav.visitar("openai.com");
        nav.mostrarEstado();
        nav.irAtras();
        nav.irAtras();
        nav.mostrarEstado();
        nav.irAdelante();
        nav.mostrarEstado();
        nav.visitar("stackoverflow.com");
        nav.mostrarEstado();
    }
}