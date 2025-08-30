package org.punto4;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        MesaAyuda mesaAyuda = new MesaAyuda();

        // Agregar tickets con diferentes severidades
        mesaAyuda.agregarTicket("Servidor caído", Severidad.CRITICA);
        mesaAyuda.agregarTicket("Email no funciona", Severidad.ALTA);
        mesaAyuda.agregarTicket("Impresora lenta", Severidad.BAJA);
        mesaAyuda.agregarTicket("Base de datos lenta", Severidad.CRITICA);
        mesaAyuda.agregarTicket("Actualización de software", Severidad.MEDIA);

        System.out.println("\nTotal tickets pendientes: " + mesaAyuda.cantidadTicketsPendientes());
        mesaAyuda.mostrarTicketsPendientes();

        System.out.println("\n=== ATENDIENDO TICKETS ===");
        while (mesaAyuda.cantidadTicketsPendientes() > 0) {
            mesaAyuda.atenderProximoTicket();
        }

        // Prueba con tickets con misma severidad pero diferentes fechas
        System.out.println("\n=== PRUEBA CON FECHAS DIFERENTES ===");

        // Crear tickets con fechas específicas para testing
        LocalDateTime ahora = LocalDateTime.now();
        Ticket ticket1 = new Ticket(100, "Ticket crítico antiguo", Severidad.CRITICA, ahora.minusHours(2));
        Ticket ticket2 = new Ticket(101, "Ticket crítico reciente", Severidad.CRITICA, ahora.minusMinutes(30));

        // Usar el nuevo método para agregar tickets existentes
        mesaAyuda.agregarTicketExistente(ticket1);
        mesaAyuda.agregarTicketExistente(ticket2);

        // Debería atender primero el más antiguo
        System.out.println("Próximo a atender (debería ser el más antiguo):");
        System.out.println(mesaAyuda.verProximoTicket());

        // Mostrar el orden de atención
        mesaAyuda.mostrarTicketsPendientes();
    }
}