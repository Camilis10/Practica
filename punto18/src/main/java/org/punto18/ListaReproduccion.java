package org.punto18;

import java.util.LinkedList;
import java.util.ListIterator;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListaReproduccion {
    private LinkedList<Cancion> canciones;
    private int indiceActual;

    public ListaReproduccion() {
        canciones = new LinkedList<>();
        indiceActual = -1;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
        // Si es la primera canción, establecer como actual
        if (indiceActual == -1 && !canciones.isEmpty()) {
            indiceActual = 0;
        }
    }

    public Cancion siguiente() {
        if (indiceActual < canciones.size() - 1) {
            indiceActual++;
            return canciones.get(indiceActual);
        }
        return null;
    }

    public Cancion anterior() {
        if (indiceActual > 0) {
            indiceActual--;
            return canciones.get(indiceActual);
        }
        return null;
    }

    public void moverCancion(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < canciones.size() &&
                toIndex >= 0 && toIndex < canciones.size()) {

            Cancion cancion = canciones.remove(fromIndex);
            canciones.add(toIndex, cancion);

            // Ajustar el índice actual si es necesario
            if (indiceActual == fromIndex) {
                indiceActual = toIndex;
            } else if (fromIndex < indiceActual && toIndex >= indiceActual) {
                indiceActual--;
            } else if (fromIndex > indiceActual && toIndex <= indiceActual) {
                indiceActual++;
            }
        }
    }

    public Cancion getCancionActual() {
        if (indiceActual >= 0 && indiceActual < canciones.size()) {
            return canciones.get(indiceActual);
        }
        return null;
    }

    public void reiniciar() {
        if (!canciones.isEmpty()) {
            indiceActual = 0;
        } else {
            indiceActual = -1;
        }
    }

    public void mostrarLista() {
        System.out.println("\n=== LISTA DE REPRODUCCIÓN ===");
        for (int i = 0; i < canciones.size(); i++) {
            String indicador = (i == indiceActual) ? "▶ " : "  ";
            System.out.println(indicador + (i + 1) + ". " + canciones.get(i));
        }
    }

    public int getTotalCanciones() {
        return canciones.size();
    }

    public int getIndiceActual() {
        return indiceActual;
    }
}
