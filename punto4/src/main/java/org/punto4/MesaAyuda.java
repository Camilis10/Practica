package org.punto4;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class MesaAyuda {
    private PriorityQueue<Ticket> colaTickets;
    private int contadorId;

    public MesaAyuda() {
        colaTickets = new PriorityQueue<>();
        contadorId = 1;
    }

    // Método para agregar un nuevo ticket
    public void agregarTicket(String descripcion, Severidad severidad) {
        Ticket nuevoTicket = new Ticket(contadorId++, descripcion, severidad);
        colaTickets.add(nuevoTicket);
        System.out.println("Ticket agregado: " + nuevoTicket);
    }

    // Método para atender el próximo ticket
    public Ticket atenderProximoTicket() {
        if (colaTickets.isEmpty()) {
            System.out.println("No hay tickets pendientes");
            return null;
        }

        Ticket ticketAtendido = colaTickets.poll();
        System.out.println("Atendiendo: " + ticketAtendido);
        return ticketAtendido;
    }

    // Método para ver el próximo ticket sin removerlo
    public Ticket verProximoTicket() {
        return colaTickets.peek();
    }

    // Método para mostrar todos los tickets pendientes
    public void mostrarTicketsPendientes() {
        if (colaTickets.isEmpty()) {
            System.out.println("No hay tickets pendientes");
            return;
        }

        System.out.println("\n=== TICKETS PENDIENTES ===");
        PriorityQueue<Ticket> copia = new PriorityQueue<>(colaTickets);
        int contador = 1;
        while (!copia.isEmpty()) {
            System.out.println(contador++ + ". " + copia.poll());
        }
    }

    // Método para obtener la cantidad de tickets pendientes
    public int cantidadTicketsPendientes() {
        return colaTickets.size();
    }

    // Método para agregar un ticket ya creado (útil para testing)
    public void agregarTicketExistente(Ticket ticket) {
        colaTickets.add(ticket);
        System.out.println("Ticket existente agregado: " + ticket);
    }
}