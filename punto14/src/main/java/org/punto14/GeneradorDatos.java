package org.punto14;

import java.util.HashSet;
import java.util.Set;

public class GeneradorDatos {

    public static Set<String> generarCorreosEjemplo() {
        Set<String> correos = new HashSet<>();
        correos.add("usuario1@gmail.com");
        correos.add("usuario2@hotmail.com");
        correos.add("usuario3@vetado.com");
        correos.add("usuario4@yahoo.com");
        correos.add("usuario5@vetado.com");
        correos.add("usuario6@gmail.com");
        correos.add("usuario7@prohibido.net");
        correos.add("usuario8@outlook.com");
        return correos;
    }

    public static Set<String> generarDominiosVetados() {
        Set<String> dominiosVetados = new HashSet<>();
        dominiosVetados.add("vetado.com");
        dominiosVetados.add("prohibido.net");
        dominiosVetados.add("spam.org");
        return dominiosVetados;
    }
}
