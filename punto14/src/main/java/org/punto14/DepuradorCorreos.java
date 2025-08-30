package org.punto14;

import java.util.Set;
import java.util.Iterator;

public class DepuradorCorreos {
    private Set<String> correos;
    private Set<String> dominiosVetados;

    public DepuradorCorreos(Set<String> correos, Set<String> dominiosVetados) {
        this.correos = correos;
        this.dominiosVetados = dominiosVetados;
    }

    public int depurarCorreos() {
        int contadorEliminados = 0;
        Iterator<String> iterator = correos.iterator();

        while (iterator.hasNext()) {
            String correo = iterator.next();
            if (esCorreoVetado(correo)) {
                iterator.remove();
                contadorEliminados++;
            }
        }

        return contadorEliminados;
    }

    private boolean esCorreoVetado(String correo) {
        if (correo == null || !correo.contains("@")) {
            return false;
        }

        String dominio = correo.substring(correo.indexOf("@") + 1);
        return dominiosVetados.contains(dominio);
    }

    public int getCantidadCorreos() {
        return correos.size();
    }

    public Set<String> getCorreos() {
        return correos;
    }
}
