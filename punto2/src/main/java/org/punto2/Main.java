//Turnos de laboratorio
package org.punto2;
public class Main {
    public static void main(String[] args) {
        TurnosLaboratorio lab = new TurnosLaboratorio();

        // Estudiantes llegan en orden
        lab.agregarEstudiante("Ana", false);    // Sin reserva
        lab.agregarEstudiante("Carlos", true);  // CON reserva → va al inicio
        lab.agregarEstudiante("Beatriz", false); // Sin reserva
        lab.agregarEstudiante("David", true);   // CON reserva → va al inicio

        lab.mostrarCola();

        // Atendiendo estudiantes
        System.out.println("Atendiendo: " + lab.atenderSiguiente());
        System.out.println("Atendiendo: " + lab.atenderSiguiente());

        lab.mostrarCola();

        // Más estudiantes llegan
        lab.agregarEstudiante("Elena", false);
        lab.agregarEstudiante("Fernando", true); // CON reserva → va al inicio

        lab.mostrarCola();
    }
}
