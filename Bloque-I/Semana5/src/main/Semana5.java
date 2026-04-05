package main;

public class Semana5 {
    public static void main(String[] args) {
        // El cliente solo conoce la Agencia (Fachada) [cite: 175]
        AgenciaViajesFacade agencia = new AgenciaViajesFacade();

        // Caso de uso 1: Viaje a Madrid [cite: 193]
        agencia.buscarViajeCompleto("15/05/2026", "20/05/2026", "Córdoba", "Madrid");

        // Caso de uso 2: Viaje a Barcelona [cite: 193]
        agencia.buscarViajeCompleto("01/06/2026", "05/06/2026", "Sevilla", "Barcelona");
    }
}
