package org.punto12;

import java.util.Hashtable;
import java.util.Map;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ContadorConcurrente {
    private Hashtable<String, Integer> contadores = new Hashtable<>();

    // Método para incrementar el contador de un usuario de manera segura
    public void incrementarContador(String usuario) {
        synchronized (contadores) {
            contadores.put(usuario, contadores.getOrDefault(usuario, 0) + 1);
        }
    }

    // Método para obtener el contador de un usuario específico
    public int obtenerContador(String usuario) {
        synchronized (contadores) {
            return contadores.getOrDefault(usuario, 0);
        }
    }

    // Método para obtener el top N de usuarios
    public List<Map.Entry<String, Integer>> obtenerTopN(int n) {
        List<Map.Entry<String, Integer>> listaEntradas;

        synchronized (contadores) {
            listaEntradas = new ArrayList<>(contadores.entrySet());
        }

        // Ordenar la lista por valor (contador) en orden descendente
        Collections.sort(listaEntradas, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue()); // Orden descendente
            }
        });

        // Devolver los primeros N elementos (o menos si hay menos de N)
        return listaEntradas.subList(0, Math.min(n, listaEntradas.size()));
    }

    // Método para mostrar el top N de usuarios
    public void mostrarTopN(int n) {
        List<Map.Entry<String, Integer>> topN = obtenerTopN(n);
        System.out.println("=== TOP " + n + " USUARIOS ===");
        for (int i = 0; i < topN.size(); i++) {
            Map.Entry<String, Integer> entrada = topN.get(i);
            System.out.println((i + 1) + ". " + entrada.getKey() + " - " + entrada.getValue() + " accesos");
        }
        System.out.println("==========================");
    }

    // Método para obtener todos los contadores (útil para debugging)
    public Hashtable<String, Integer> getContadores() {
        synchronized (contadores) {
            return new Hashtable<>(contadores); // Devolver copia para seguridad
        }
    }
}